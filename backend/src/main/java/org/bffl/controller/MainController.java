package org.bffl.controller;

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
    private Assigned_targetRepo assigned_targetRepo;

    @Autowired
    private Short_urlRepo short_urlRepo;

    @Autowired
    private TagRepo tagRepo;

    @Autowired
    private Url_callRepo url_callRepo;

    @Autowired
    private Url_has_tagRepo url_has_tagRepo;

    @Autowired
    private User_has_groupRepo user_has_groupRepo;

    @GetMapping("/shortURLsByGroup")
    public ResponseEntity<List<Object>> getAllShortURLsWithCurrentTargetByGroup(@RequestParam("group_name") String group_name){

        List<Object> list = this.short_urlRepo.findAllShortURLsWithCurrentTargetByGroup(group_name);
        if(list != null && list.size() > 0){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/groupsOfUser")
    public ResponseEntity<List<Object>> getAllGroupsByUser(HttpServletRequest request){

        String user_id = KeycloakSecurityConfig.getAccessToken(request).getSubject();

        List<Object> list = this.user_has_groupRepo.findAlLGroupsOfUser(user_id);
        if(list != null && list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/shortURLByID")
    public ResponseEntity<List<Object>> getShortURLWithCurrentTargetByID(@RequestParam("short_url_id") int short_url_id){

        List<Object> list = this.short_urlRepo.findShortURLWithCurrentTargetByID(short_url_id);
        if(list != null && list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/tagsAssignedToShortURL")
    public ResponseEntity<List<Object>> getAllTagsAssignedToShortURL(@RequestParam("short_url_id") int short_url_id){

        List<Object> list = this.tagRepo.findAllTagsAssignedToShortURL(short_url_id);
        if(list != null && list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/possibleTagsForShortURL")
    public ResponseEntity<List<Object>> getAllTagsOfGroup(@RequestParam("short_url_id") int short_url_id){

        List<Object> list = this.tagRepo.findAllPossibleTagsForShortURL(short_url_id);
        if(list != null && list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/tagsByGroup")
    public ResponseEntity<List<Object>> getAllTagsOfGroup(@RequestParam("group_name") String group_name){

        List<Object> list = this.tagRepo.findAllTagsOfGroup(group_name);
        if(list != null && list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/targetAssignmentHistoryForShortURL")
    public ResponseEntity<List<Object>> getAllAssignedTargetsOfShortURL(@RequestParam("short_url_id") int short_url_id){

        List<Object> list = this.assigned_targetRepo.findAllAssignedTargetsOfShortURL(short_url_id);
        if(list != null && list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/callsOfShortURL")
    public ResponseEntity<List<Object>> getAllCallsOfShortURL(@RequestParam("short_url_id") int short_url_id){

        List<Object> list = this.url_callRepo.findAllCallsOfShortURL(short_url_id);
        if(list != null && list.size() > 0) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/createShortURLForGroupWithTags")
    public ResponseEntity insertNewShortURLWithTarget(
            @RequestParam("group_name") String group_name,
            @RequestParam("custom_suffix") String custom_suffix,
            @RequestParam("scope") int scope,
            @RequestParam("delete_flag") boolean delete_flag,
            @RequestParam("update_flag") boolean update_flag,
            @RequestParam("target_url") String target_url,
            @RequestParam("assigned_tag_ids") List<Integer> assigned_tag_ids){

        boolean isSuccessfull = this.short_urlRepo.saveShortURL(group_name, custom_suffix, scope, delete_flag, update_flag);
        if(!isSuccessfull) return new ResponseEntity(HttpStatus.NOT_FOUND);

        isSuccessfull = this.assigned_targetRepo.saveTargetOfNewShortURL(group_name, custom_suffix, target_url);
        if(!isSuccessfull) return new ResponseEntity(HttpStatus.NOT_FOUND);

        if (assigned_tag_ids != null && assigned_tag_ids.size() > 0) {
            for(int tag_id: assigned_tag_ids){
                isSuccessfull = this.url_has_tagRepo.saveTagOfGroupToShortURLBySuffix(tag_id, group_name, custom_suffix);
                if(!isSuccessfull) return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/assignTagToShortURL")
    public ResponseEntity assignTagOfGroupToShortURLByID(
            @RequestParam("tag_id") int tag_id,
            @RequestParam("short_url_id") int short_url_id){

        boolean isSuccessfull = this.url_has_tagRepo.saveTagOfGroupToShortURLByID(tag_id, short_url_id);
        if(!isSuccessfull) return new ResponseEntity(HttpStatus.NOT_FOUND);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/createGroup")
    public ResponseEntity createGroup(
            @RequestParam("group_name") String group_name,
            @RequestParam("max_size") int max_size){

        boolean isSuccessfull = this.app_groupRepo.saveGroup(group_name, max_size);
        if(!isSuccessfull) return new ResponseEntity(HttpStatus.NOT_FOUND);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/addUserToGroup")
    public ResponseEntity assignUserToGroup(
            @RequestParam("group_name") String group_name,
            @RequestParam("user_id") String user_id,
            @RequestParam("end_timestamp") Integer end_timestamp){

        boolean isSuccessfull = this.user_has_groupRepo.saveUserAssignToGroup(group_name, user_id, end_timestamp);
        if(!isSuccessfull) return new ResponseEntity(HttpStatus.NOT_FOUND);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/addUserAsAdminToGroup")
    public ResponseEntity assignUserAsAdminToGroup(
            HttpServletRequest request,
            @RequestParam("group_name") String group_name,
            @RequestParam("new_user_id") String new_user_id,
            @RequestParam("end_timestamp") Integer end_timestamp){

        String groupmember_user_id = KeycloakSecurityConfig.getAccessToken(request).getSubject();

        boolean isSuccessfull = this.user_has_groupRepo.saveUserAssignAsAdminToGroup(groupmember_user_id, group_name, new_user_id, end_timestamp);
        if(!isSuccessfull) return new ResponseEntity(HttpStatus.NOT_FOUND);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/updateShortURL")
    public ResponseEntity updateAttributesOfShortURL(
            @RequestParam("short_url_id") int short_url_id,
            @RequestParam("custom_suffix") String custom_suffix,
            @RequestParam("scope") int scope,
            @RequestParam("delete_flag") Boolean delete_flag,
            @RequestParam("update_flag") Boolean update_flag,
            @RequestParam("target_url") String target_url){

        boolean isSuccessfull = false;

        if(custom_suffix != null && custom_suffix.length() > 0){
            isSuccessfull = this.short_urlRepo.updateSuffixOfShortURL(short_url_id, custom_suffix);
        }
        if(!isSuccessfull) return new ResponseEntity(HttpStatus.NOT_FOUND);

        if(scope >= (System.currentTimeMillis() / 1000) + 3600){
            isSuccessfull = this.short_urlRepo.updateScopeOfShortURL(short_url_id, scope);
        }
        if(!isSuccessfull) return new ResponseEntity(HttpStatus.NOT_FOUND);

        if(delete_flag != null){
            isSuccessfull = this.short_urlRepo.updateDeleteFlagOfShortURL(short_url_id, delete_flag);
        }
        if(!isSuccessfull) return new ResponseEntity(HttpStatus.NOT_FOUND);

        if(update_flag != null){
            isSuccessfull = this.short_urlRepo.updateUpdateFlagOfShortURL(short_url_id, update_flag);
        }
        if(!isSuccessfull) return new ResponseEntity(HttpStatus.NOT_FOUND);

        if(target_url != null && target_url.length() > 0){
            isSuccessfull = this.assigned_targetRepo.saveNewTargetOfShortURL(short_url_id, target_url);
        }
        if(!isSuccessfull) return new ResponseEntity(HttpStatus.NOT_FOUND);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/updateTag")
    public ResponseEntity updateAttributesOfShortURL(
            @RequestParam("tag_id") int tag_id,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("color") String color){

        boolean isSuccessfull = false;

        if(title != null && title.length() > 0){
            isSuccessfull = this.tagRepo.updateTitleOfTag(tag_id, title);
        }
        if(!isSuccessfull) return new ResponseEntity(HttpStatus.NOT_FOUND);

        if(description != null && description.length() > 0){
            isSuccessfull = this.tagRepo.updateDescriptionOfTag(tag_id, description);
        }
        if(!isSuccessfull) return new ResponseEntity(HttpStatus.NOT_FOUND);

        if(color != null && color.length() == 6){
            isSuccessfull = this.tagRepo.updateColorOfTag(tag_id, color);
        }
        if(!isSuccessfull) return new ResponseEntity(HttpStatus.NOT_FOUND);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/updateGroupSize")
    public ResponseEntity updateAttributesOfShortURL(
            @RequestParam("group_name") String group_name,
            @RequestParam("max_size") int max_size){

        boolean isSuccessfull = this.app_groupRepo.updateMaxSizeOfGroup(group_name, max_size);
        if(!isSuccessfull) return new ResponseEntity(HttpStatus.NOT_FOUND);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/updateUserOfGroupAssignment")
    public ResponseEntity updateAdminStateOfUser(
            HttpServletRequest request,
            @RequestParam("group_name") String group_name,
            @RequestParam("searched_user_id") String searched_user_id,
            @RequestParam("end_timestamp") Integer end_timestamp,
            @RequestParam("admin_flag") Boolean admin_flag){

        String groupmember_user_id = KeycloakSecurityConfig.getAccessToken(request).getSubject();
        boolean isSuccessfull = false;

        if(end_timestamp != null && end_timestamp > 0){
            isSuccessfull = this.user_has_groupRepo.updateEndTimestampOfUser(groupmember_user_id, searched_user_id, group_name, end_timestamp);
        }
        if(!isSuccessfull) return new ResponseEntity(HttpStatus.NOT_FOUND);

        if(admin_flag != null){
            isSuccessfull = this.user_has_groupRepo.updateAdminStateOfUser(groupmember_user_id, group_name, searched_user_id, admin_flag);
        }
        if(!isSuccessfull) return new ResponseEntity(HttpStatus.NOT_FOUND);

        return new ResponseEntity(HttpStatus.OK);

    }

    @PostMapping("/deleteUserFromGroup")
    public ResponseEntity deleteUserOfGroupAssignment(
            HttpServletRequest request,
            @RequestParam("group_name") String group_name,
            @RequestParam("searched_user_id") String searched_user_id){

        String groupmember_user_id = KeycloakSecurityConfig.getAccessToken(request).getSubject();

        boolean isSuccessfull = this.user_has_groupRepo.deleteUserOfGroupAssignment(groupmember_user_id, searched_user_id, group_name);
        if(!isSuccessfull) return new ResponseEntity(HttpStatus.NOT_FOUND);

        return new ResponseEntity(HttpStatus.OK);

    }

    @PostMapping("/deleteShortURL")
    public ResponseEntity deleteShortURLByID(@RequestParam("short_url_id") int short_url_id){

        boolean isSuccessfull = this.short_urlRepo.deleteShortURL(short_url_id);
        if(!isSuccessfull) return new ResponseEntity(HttpStatus.NOT_FOUND);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/deleteTag")
    public ResponseEntity deleteTagByID(@RequestParam("tag_id") int tag_id){

        boolean isSuccessfull = this.tagRepo.deleteTagById(tag_id);
        if(!isSuccessfull) return new ResponseEntity(HttpStatus.NOT_FOUND);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/deleteGroup")
    public ResponseEntity deleteGroupByID(@RequestParam("group_name") String group_name){

        boolean isSuccessfull = this.app_groupRepo.deleteGroupById(group_name);
        if(!isSuccessfull) return new ResponseEntity(HttpStatus.NOT_FOUND);

        return new ResponseEntity(HttpStatus.OK);
    }

}
