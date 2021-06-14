package org.bffl.controller;

import org.bffl.dbConnector.dao.repos.*;
import org.bffl.dbConnector.dao.types.postParamTypes.*;
import org.bffl.iamConnector.iamConfig.KeycloakSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
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

    @GetMapping("/numberOfUrlCalls")
    public ResponseEntity<Integer> getNumberOfURLCalls(@RequestParam("short_url_id") int short_url_id){

        List<Object> list = this.url_callRepo.findAllCallsOfShortURL(short_url_id);
        if(list != null && list.size() == 1) {
            int numberOfURLCalls = Integer.parseInt(String.valueOf(list.get(0)));
            return new ResponseEntity<>(numberOfURLCalls, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/isUserAdminOfGroup")
    public ResponseEntity<Boolean> getIsUserAdminOfGroup(@RequestParam("group_name") String group_name, HttpServletRequest request){

        String groupmember_user_id = KeycloakSecurityConfig.getAccessToken(request).getSubject();
        List<Object> list = this.user_has_groupRepo.findIsUserAdminOfGroup(groupmember_user_id, group_name);
        if(list != null && list.size() == 1) {
            boolean isAdmin = Boolean.parseBoolean(String.valueOf(list.get(0)));
            return new ResponseEntity<>(isAdmin, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/createShortURLForGroupWithTags")
    public int insertNewShortURLWithTarget(@RequestBody POST_ShortURLWithTargetAndTags body){

        if(this.short_urlRepo.saveShortURL(body.getGroup_name(), body.getCustom_suffix(), body.getScope(), body.isDelete_flag(), body.isUpdate_flag()) != 1 ||
                this.assigned_targetRepo.saveTargetOfNewShortURL(body.getGroup_name(), body.getCustom_suffix(), body.getTarget_url()) != 1)
            return HttpStatus.BAD_REQUEST.value();

        List<Integer> assignedTagIds = new ArrayList<>();
        for(int tagId: Arrays.asList(body.getAssigned_tag_ids())) {
            assignedTagIds.add(tagId);
        }

        for(int tagId: assignedTagIds){
            if(this.url_has_tagRepo.saveTagOfGroupToShortURLBySuffix(tagId, body.getGroup_name(), body.getCustom_suffix()) != 1) {
                return HttpStatus.BAD_REQUEST.value();
            }
        }

        return HttpStatus.CREATED.value();
    }

    @PostMapping("/assignTargetToShortURL")
    public int assignTargetToShortUrl(@RequestBody POST_TargetUrl body){
        int modifiedRows = this.assigned_targetRepo.saveNewTargetOfShortURL(body.getShort_url_id(), body.getTarget_url());
        if(modifiedRows != 1) return HttpStatus.BAD_REQUEST.value();

        return HttpStatus.CREATED.value();
    }

    @PostMapping("/assignTagToShortURL")
    public int assignTagOfGroupToShortURLByID(@RequestBody POST_TagToShortURLAssignment body){

        int modifiedRows = this.url_has_tagRepo.saveTagOfGroupToShortURLByID(body.getTag_id(), body.getShort_url_id());
        if(modifiedRows != 1) return HttpStatus.BAD_REQUEST.value();

        return HttpStatus.CREATED.value();
    }

    @PostMapping("/createGroup")
    public int createGroup(@RequestBody POST_Group body){

        int modifiedRows = this.app_groupRepo.saveGroup(body.getGroup_name(), body.getMax_size());
        if(modifiedRows != 1) return HttpStatus.BAD_REQUEST.value();

        return HttpStatus.CREATED.value();
    }

    @PostMapping("/addUserToGroup")
    public int assignUserToGroup(@RequestBody POST_UserToGroupAssignment body){

        int modifiedRows = this.user_has_groupRepo.saveUserAssignToGroup(body.getGroup_name(), body.getUser_id(), body.getEnd_timestamp());
        if(modifiedRows != 1) return HttpStatus.BAD_REQUEST.value();

        return HttpStatus.CREATED.value();
    }

    @PostMapping("/addUserAsAdminToGroup")
    public int assignUserAsAdminToGroup(@RequestBody POST_UserToGroupAssignment body, HttpServletRequest request){

        String groupmember_user_id = KeycloakSecurityConfig.getAccessToken(request).getSubject();

        int modifiedRows = this.user_has_groupRepo.saveUserAssignAsAdminToGroup(groupmember_user_id, body.getGroup_name(), body.getUser_id(), body.getEnd_timestamp());
        if(modifiedRows != 1) return HttpStatus.BAD_REQUEST.value();

        return HttpStatus.CREATED.value();
    }

    @PostMapping("/updateDeleteFlag")
    public int updateDeleteFlagOfShortURL(@RequestBody POST_ModificationFlag body) {
        int modifiedRows = this.short_urlRepo.updateDeleteFlagOfShortURL(body.getShort_url_id(), body.isFlag());
        if(modifiedRows < 1) return HttpStatus.BAD_REQUEST.value();

        return HttpStatus.OK.value();
    }

    @PostMapping("/updateUpdateFlag")
    public int updateUpdateFlagOfShortURL(@RequestBody POST_ModificationFlag body){
        int modifiedRows = this.short_urlRepo.updateUpdateFlagOfShortURL(body.getShort_url_id(), body.isFlag());
        if(modifiedRows < 1) return HttpStatus.BAD_REQUEST.value();

        return HttpStatus.OK.value();
    }

    @PostMapping("/updateShortURL")
    public int updateAttributesOfShortURL(@RequestBody POST_ShortURL body){

        int id = body.getShort_url_id();

        try {
            if(body.getCustom_suffix().length() < 1 ||
                    body.getTarget_url().length() < 1 ||
                    body.getCustom_suffix() == null ||
                    body.getUpdate_flag() == null ||
                    body.getScope() >= (System.currentTimeMillis() / 1000) + 3600) {
                return HttpStatus.BAD_REQUEST.value();
            }
        } catch (Exception exception) {
            return HttpStatus.BAD_REQUEST.value();
        }

        if(this.short_urlRepo.updateSuffixOfShortURL(id, body.getCustom_suffix()) < 1 ||
            this.short_urlRepo.updateDeleteFlagOfShortURL(id, body.getDelete_flag()) < 1 ||
            this.short_urlRepo.updateUpdateFlagOfShortURL(id, body.getUpdate_flag()) < 1 ||
            this.assigned_targetRepo.saveNewTargetOfShortURL(id, body.getTarget_url()) < 1 ||
            this.short_urlRepo.updateScopeOfShortURL(id, body.getScope()) < 1) {
            return HttpStatus.BAD_REQUEST.value();
        }

        return HttpStatus.OK.value();
    }

    @PostMapping("/updateTag")
    public int updateAttributesOfTag(@RequestBody POST_Tag body){

        int id = body.getTag_id();

        try {
            if(body.getTitle().length() < 1 ||
                    body.getDescription().length() < 1 ||
                    body.getColor().length() != 6) {
                return HttpStatus.BAD_REQUEST.value();
            }
        } catch (Exception exception) {
            return  HttpStatus.BAD_REQUEST.value();
        }

        if(this.tagRepo.updateTitleOfTag(id, body.getTitle()) < 1 ||
            this.tagRepo.updateDescriptionOfTag(id, body.getDescription()) < 1 ||
            this.tagRepo.updateColorOfTag(id, body.getColor()) < 1) {
            return HttpStatus.BAD_REQUEST.value();
        }
        return HttpStatus.OK.value();
    }

    @PostMapping("/updateGroupSize")
    public int updateGroupSize(@RequestBody POST_Group body){

        int modifiedRows = this.app_groupRepo.updateMaxSizeOfGroup(body.getGroup_name(), body.getMax_size());
        if(modifiedRows < 1) return HttpStatus.BAD_REQUEST.value();

        return HttpStatus.OK.value();
    }

    @PostMapping("/updateUserOfGroupAssignment")
    public int updateAdminStateOfUser(@RequestBody POST_AdminToGroupAssignment body, HttpServletRequest request){

        String groupmember_user_id = KeycloakSecurityConfig.getAccessToken(request).getSubject();
        int modifiedRows = 0;

        if(body.getEnd_timestamp() != null && body.getEnd_timestamp() > 0){
            modifiedRows = this.user_has_groupRepo.updateEndTimestampOfUser(groupmember_user_id, body.getUser_id(), body.getGroup_name(), body.getEnd_timestamp());
        }
        if(modifiedRows < 1) return HttpStatus.BAD_REQUEST.value();

        if(body.getAdmin_flag() != null){
            modifiedRows = this.user_has_groupRepo.updateAdminStateOfUser(groupmember_user_id, body.getGroup_name(), body.getUser_id(), body.getAdmin_flag());
        }
        if(modifiedRows < 1) return HttpStatus.BAD_REQUEST.value();

        return HttpStatus.OK.value();

    }

    @PostMapping("/deleteUserFromGroup")
    public int deleteUserOfGroupAssignment(@RequestBody POST_UserToGroupAssignmentWithoutTimestamp body, HttpServletRequest request){

        String groupmember_user_id = KeycloakSecurityConfig.getAccessToken(request).getSubject();

        int modifiedRows = this.user_has_groupRepo.deleteUserOfGroupAssignment(groupmember_user_id, body.getUser_id(), body.getGroup_name());
        if(modifiedRows < 1) return HttpStatus.BAD_REQUEST.value();

        return HttpStatus.OK.value();

    }

    @PostMapping("/deleteShortURL")
    public int deleteShortURLByID(@RequestBody POST_ShortURLId body){

        int modifiedRows = this.short_urlRepo.deleteShortURL(body.getShort_url_id());
        if(modifiedRows < 1) return HttpStatus.BAD_REQUEST.value();

        return HttpStatus.OK.value();
    }

    @PostMapping("/deleteTag")
    public int deleteTagByID(@RequestBody POST_TagId body){

        int modifiedRows = this.tagRepo.deleteTagById(body.getTag_id());
        if(modifiedRows < 1) return HttpStatus.BAD_REQUEST.value();

        return HttpStatus.OK.value();
    }

    @PostMapping("/deleteGroup")
    public int deleteGroupByID(@RequestBody POST_GroupName body){

        int modifiedRows = this.app_groupRepo.deleteGroupById(body.getGroup_name());
        if(modifiedRows < 1) return HttpStatus.BAD_REQUEST.value();

        return HttpStatus.OK.value();
    }

    @PostMapping("/deleteUrlHasTagAssignment")
    public int deleteURLHasTagAssignment(@RequestBody POST_TagToShortURLAssignment body){

        int modifiedRows = this.url_has_tagRepo.deleteUrlHasTagAssignment(body.getTag_id(), body.getShort_url_id());
        if(modifiedRows < 1) return HttpStatus.BAD_REQUEST.value();

        return HttpStatus.OK.value();
    }

    @PostMapping("/deleteTargetOfShortUrl")
    public int deleteTargetOfShortUrl(@RequestBody POST_TargetAssignment body){

        int modifiedRows = this.assigned_targetRepo.deleteTargetOfShortURL(body.getShort_url_id(), Timestamp.valueOf(body.getAssign_timestamp()));
        if(modifiedRows < 1) return HttpStatus.BAD_REQUEST.value();

        return HttpStatus.OK.value();
    }
}
