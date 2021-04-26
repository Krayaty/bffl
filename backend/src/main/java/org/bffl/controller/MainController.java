package org.bffl.controller;

import org.bffl.dbConnector.dao.model.Assigned_target;
import org.bffl.dbConnector.services.AppService;
import org.keycloak.representations.AccessToken;
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

    @Autowired
    private AccessToken accessToken;

    @GetMapping("/target_urls")
    public ResponseEntity<List<Assigned_target>> getAllTargetURLs() {
        return app_Service.findAllTargetURLs();
    }

    @GetMapping("/allShortURLsByGroup")
    public ResponseEntity<List<Object>> getAllShortURLsByGroup(@RequestParam("group_name") String group_name){
        System.out.println("Hallo");
        return this.app_Service.getAllShortURLsWithCurrentTargetByGroupId(group_name);
    }

}
