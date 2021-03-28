package org.bffl.controller;

import org.bffl.dbConnector.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin(origins = "https://api.bffl.de")
@RestController
@RequestMapping(value="/s", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

    //Controller für die weiterleitung von ShortURLs

    @Autowired
    ApiService api;

    @GetMapping("/{group}/{shortURL}")
    public ResponseEntity<HttpStatus> getAllTargetURLs(HttpServletResponse response,
                                                       @PathVariable("group") String groupID,
                                                       @PathVariable("shortURL") String shortUrlID) throws IOException {

        return api.redirectToTargetURL(response, groupID, shortUrlID);

    }

}
