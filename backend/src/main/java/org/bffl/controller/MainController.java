package org.bffl.controller;

import org.bffl.dbConnector.dao.model.Target_url;
import org.bffl.dbConnector.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "https://bfflshort.de"}, maxAge = 3600L)
@RestController
@RequestMapping(value="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class MainController {

    //controller für die WebApp

    @Autowired
    private AppService app_Service;

    @GetMapping("/short_urls")
    public ResponseEntity<List<Target_url>> getAllShortURLsWithTargetURLsForGroup(@PathVariable("group") String groupID) {
        return app_Service.findAllTarget_urls();
    }

    @GetMapping("/target_urls")
    public ResponseEntity<List<Target_url>> getAllTargetURLs() {
        return app_Service.findAllTarget_urls();
    }

}
