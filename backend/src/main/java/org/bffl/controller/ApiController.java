package org.bffl.controller;

import org.bffl.dbConnector.dao.repos.Assigned_targetRepo;
import org.bffl.dbConnector.dao.repos.Url_callRepo;
import org.bffl.dbConnector.dao.types.IP_adress;
import org.keycloak.authorization.client.util.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin(origins = "https://api.bfflshort.de")
@RestController
@RequestMapping(value="/s", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

    @Autowired
    private Assigned_targetRepo assigned_targetRepo;

    @Autowired
    private Url_callRepo url_callRepo;

    private static String getClientIp(HttpServletRequest request) {
        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }

    @GetMapping("/{group_name}/{custom_suffix}")
    public ResponseEntity redirectToAssignedTargetOfShortURL(
            HttpServletRequest request,
            HttpServletResponse response,
            @PathVariable("group_name") String group_name,
            @PathVariable("custom_suffix") String custom_suffix) throws IOException {

            String target = this.assigned_targetRepo.findAssignedTargetOfShortUrl(group_name, custom_suffix);
            if(target != null && target.length() > 0) response.sendRedirect(target);

            IP_adress clientIp = new IP_adress(this.getClientIp(request));
            boolean isSuccessfull = this.url_callRepo.saveUrlCall(group_name, custom_suffix, clientIp);
            if(!isSuccessfull) return new ResponseEntity(HttpStatus.NOT_FOUND);

            return new ResponseEntity(HttpStatus.OK);

    }

}
