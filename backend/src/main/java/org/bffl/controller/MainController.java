package org.bffl.controller;

import org.bffl.dbConnector.dao.model.Assigned_target;
import org.bffl.dbConnector.services.AppService;
import org.bffl.iamConnector.iamConfig.KeycloakSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "https://bfflshort.de"}, maxAge = 3600L)
@RestController
@RequestMapping(value="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class MainController {

    //controller für die WebApp

    @Autowired
    private AppService app_Service;

    @GetMapping("/allShortURLsByGroup")
    public ResponseEntity<List<Object>> getAllShortURLsByGroup(@RequestParam("group_name") String group_name){
        return this.app_Service.getAllShortURLsWithCurrentTargetByGroupId(group_name);
    }

    @GetMapping("/groupsOfUser")
    public ResponseEntity<List<Object>> getAllGroupsByUser(HttpServletRequest request){
        String user_id = KeycloakSecurityConfig.getAccessToken(request).getSubject();
        return this.app_Service.getAllGroupsOfGivenUser(user_id);
    }

}
