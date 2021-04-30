package org.bffl.controller;

import org.bffl.dbConnector.dao.model.Tag;
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

    @GetMapping("/shortURLsByGroup")
    public ResponseEntity<List<Object>> getAllShortURLsWithCurrentTargetByGroup(@RequestParam("group_name") String group_name){
        return this.app_Service.getAllShortURLsWithCurrentTargetByGroup(group_name);
    }

    @GetMapping("/groupsOfUser")
    public ResponseEntity<List<Object>> getAllGroupsByUser(HttpServletRequest request){
        String user_id = KeycloakSecurityConfig.getAccessToken(request).getSubject();
        return this.app_Service.getAllGroupsOfUser(user_id);
    }

    @GetMapping("/shortURLByID")
    public ResponseEntity<List<Object>> getShortURLWithCurrentTargetByID(@RequestParam("short_url_id") int short_url_id){
        return this.app_Service.getShortURLWithCurrentTargetByID(short_url_id);
    }

    @GetMapping("/tagsAssignedToShortURL")
    public ResponseEntity<List<Object>> getAllTagsAssignedToShortURL(@RequestParam("short_url_id") int short_url_id){
        return this.app_Service.getAllTagsAssignedToShortURL(short_url_id);
    }

    @GetMapping("/possibleTagsForShortURL")
    public ResponseEntity<List<Object>> getAllTagsOfGroup(@RequestParam("short_url_id") int short_url_id){
        return this.app_Service.getAllPossibleTagsForShortURL(short_url_id);
    }

    @GetMapping("/tagsByGroup")
    public ResponseEntity<List<Tag>> getAllTagsOfGroup(@RequestParam("group_name") String group_name){
        return this.app_Service.getAllTagsOfGroup(group_name);
    }

}
