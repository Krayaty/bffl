package org.bffl.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin(origins = "https://api.bfflshort.de")
@RestController
@RequestMapping(value="/s", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

    @GetMapping("/{group}/{shortURL}")
    public void getAllTargetURLs(
            HttpServletResponse response,
            @PathVariable("group") String groupID,
            @PathVariable("shortURL") String shortUrlID) throws IOException {

        response.sendRedirect("https://google.de");
    }

}
