package org.bffl.controller;

import org.bffl.dbConnector.dao.model.Short_url;
import org.bffl.dbConnector.dao.repos.Assigned_targetRepo;
import org.bffl.dbConnector.dao.repos.Short_urlRepo;
import org.bffl.dbConnector.dao.repos.Url_callRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.sql.Timestamp;
import java.util.Arrays;

@CrossOrigin(origins = "https://api.bfflshort.de")
@RestController
@RequestMapping(value="/s", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

    @Autowired
    private Assigned_targetRepo assigned_targetRepo;

    @Autowired
    private Short_urlRepo short_urlRepo;

    @Autowired
    private Url_callRepo url_callRepo;

    @GetMapping("/{group_name}/{custom_suffix}")
    public ResponseEntity redirectToAssignedTargetOfShortURL(
            HttpServletRequest request,
            HttpServletResponse response,
            @PathVariable("group_name") String group_name,
            @PathVariable("custom_suffix") String custom_suffix) throws IOException {

        Short_url shortUrlValidity = this.short_urlRepo.findShortURLBySuffix(group_name, custom_suffix).get(0);
        Timestamp endOfValidity = new Timestamp(shortUrlValidity.getCreate_timestamp().getTime() + ((long) shortUrlValidity.getScope() * 1000));
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        if (shortUrlValidity.getScope() != -1 && endOfValidity.compareTo(currentTimestamp) < 0) {
            String errorPage =
                    "<!doctype html>\n" +
                    "<html lang=\"de\">\n" +
                    "   <head>\n" +
                    "       <meta charset=\"utf-8\">\n" +
                    "       <title>BFFL-Error</title>\n" +
                    "   </head>\n" +
                    "   <body>\n" +
                    "       <h1>Error</h1>\n" +
                    "       <p>This is not a valid ShortUrl anymore.</p>\n" +
                    "   </body>\n" +
                    "</html>";
            response.resetBuffer();
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.setHeader("Content-Type", "text/html");
            response.getOutputStream().print(errorPage);
            response.flushBuffer();
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        String target = this.assigned_targetRepo.findAssignedTargetOfShortUrl(group_name, custom_suffix);
        if(target != null && target.length() > 0)
            response.sendRedirect(target);

        String clientIp = getClientIp(request);
        if(!isValidIp(clientIp))
            throw new InvalidParameterException("The clients ip-adress seems to be invalid. \n Found: " + clientIp +
                    "\n But needs [0-255]\\.[0-255]\\.[0-255]\\.[0-255]\\.");

        int modifiedRows = this.url_callRepo.saveUrlCall(group_name, custom_suffix, clientIp);
        if(modifiedRows != 1)
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        return new ResponseEntity(HttpStatus.OK);

    }

    private static String getClientIp(HttpServletRequest request) {
        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        if(remoteAddr.contains(",")){
            return remoteAddr.split(",")[0];
        }

        if (remoteAddr.equals("0:0:0:0:0:0:0:1"))
            return "127.0.0.1";

        return remoteAddr;
    }

    private static boolean isValidIp(String ip){
        int[] ipArr = Arrays.stream(ip.split("\\.")).mapToInt(Integer::parseInt).toArray();
        for(int ipPart : ipArr) {
            if(ipPart < 0 || ipPart > 255) return false;
        }
        return true;
    }

}
