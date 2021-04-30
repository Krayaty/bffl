package org.bffl.controller;

import org.bffl.dbConnector.dao.model.Tag;
import org.bffl.dbConnector.dao.repos.*;
import org.bffl.iamConnector.iamConfig.KeycloakSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "https://bfflshort.de"}, maxAge = 3600L)
@RestController
@RequestMapping(value="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class MainController {

    @Autowired
    private App_groupRepo app_groupRepo;

    @Autowired
    private App_userRepo app_userRepo;

    @Autowired
    private CredentialRepo credentialRepo;

    @Autowired
    private Short_urlRepo short_urlRepo;

    @Autowired
    private TagRepo tagRepo;

    @Autowired
    private Url_callRepo url_callRepo;

    @Autowired
    private Url_has_tagRepo url_has_tagRepo;

    @Autowired
    private Assigned_targetRepo assigned_targetRepo;

    @Autowired
    private User_has_groupRepo user_has_groupRepo;

    @GetMapping("/shortURLsByGroup")
    public ResponseEntity<List<Object>> getAllShortURLsWithCurrentTargetByGroup(@RequestParam("group_name") String group_name){
        return new ResponseEntity<List<Object>>(
                this.short_urlRepo.findAllShortURLsWithCurrentTargetByGroup(group_name),
                HttpStatus.OK);
    }

    @GetMapping("/groupsOfUser")
    public ResponseEntity<List<Object>> getAllGroupsByUser(HttpServletRequest request){
        String user_id = KeycloakSecurityConfig.getAccessToken(request).getSubject();
        return new ResponseEntity<List<Object>>(
                this.user_has_groupRepo.findAlLGroupsOfUser(user_id),
                HttpStatus.OK);
    }

    @GetMapping("/shortURLByID")
    public ResponseEntity<List<Object>> getShortURLWithCurrentTargetByID(@RequestParam("short_url_id") int short_url_id){
        return new ResponseEntity<List<Object>>(
                this.short_urlRepo.findShortURLWithCurrentTargetByID(short_url_id),
                HttpStatus.OK);
    }

    @GetMapping("/tagsAssignedToShortURL")
    public ResponseEntity<List<Object>> getAllTagsAssignedToShortURL(@RequestParam("short_url_id") int short_url_id){
        return new ResponseEntity<List<Object>>(
                this.tagRepo.findAllTagsAssignedToShortURL(short_url_id),
                HttpStatus.OK);
    }

    @GetMapping("/possibleTagsForShortURL")
    public ResponseEntity<List<Object>> getAllTagsOfGroup(@RequestParam("short_url_id") int short_url_id){
        return new ResponseEntity<List<Object>>(
                this.tagRepo.findAllPossibleTagsForShortURL(short_url_id),
                HttpStatus.OK);
    }

    @GetMapping("/tagsByGroup")
    public ResponseEntity<List<Tag>> getAllTagsOfGroup(@RequestParam("group_name") String group_name){
        return new ResponseEntity<List<Tag>>(
                this.tagRepo.findAllTagsOfGroup(group_name),
                HttpStatus.OK);
    }

    @PostMapping("/createShortURLForGroupWithOptionalTags")
    public ResponseEntity insertNewShortURLWithTarget(
            @RequestParam("group_name") String group_name,
            @RequestParam("custom_suffix") String custom_suffix,
            @RequestParam("scope") String scope,
            @RequestParam("delete_flag") String delete_flag,
            @RequestParam("update_flag") String update_flag,
            @RequestParam("target_url") String target_url,
            @RequestParam(value = "assigned_tag_ids", required = false) List<Integer> assigned_tag_ids){

        this.short_urlRepo.saveShortURL(group_name, custom_suffix, scope, delete_flag, update_flag);
        this.assigned_targetRepo.saveTargetOfNewShortURL(group_name, custom_suffix, target_url);

        if (assigned_tag_ids != null && assigned_tag_ids.size() > 0) {
            assigned_tag_ids.forEach(tag_id -> {
                this.url_has_tagRepo.saveTagOfGroupToShortURLBySuffix(tag_id, group_name, custom_suffix);
            });
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/createShortURLForGroupWithOptionalTags")
    public ResponseEntity assignTagOfGroupToShortURLByID(int tag_id, int short_url_id){
        this.url_has_tagRepo.saveTagOfGroupToShortURLByID(tag_id, short_url_id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
