package org.bffl.dbConnector.services;

import org.bffl.dbConnector.dao.model.Tag;
import org.bffl.dbConnector.dao.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppService {

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

    public ResponseEntity<List<Object>> getAllShortURLsWithCurrentTargetByGroup(String group_name) {
        return new ResponseEntity<List<Object>>(
                this.short_urlRepo.findAllShortURLsWithCurrentTargetByGroup(group_name),
                HttpStatus.OK);
    }

    public ResponseEntity<List<Object>> getAllGroupsOfUser(String user_id) {
        return new ResponseEntity<List<Object>>(
                this.user_has_groupRepo.findAlLGroupsOfUser(user_id),
                HttpStatus.OK);
    }

    public ResponseEntity<List<Object>> getShortURLWithCurrentTargetByID(int short_url_id){
        return new ResponseEntity<List<Object>>(
                this.short_urlRepo.findShortURLWithCurrentTargetByID(short_url_id),
                HttpStatus.OK);
    }

    public ResponseEntity<List<Object>> getAllTagsAssignedToShortURL(int short_url_id){
        return new ResponseEntity<List<Object>>(
                this.tagRepo.findAllTagsAssignedToShortURL(short_url_id),
                HttpStatus.OK);
    }

    public ResponseEntity<List<Object>> getAllPossibleTagsForShortURL(int short_url_id){
        return new ResponseEntity<List<Object>>(
                this.tagRepo.findAllPossibleTagsForShortURL(short_url_id),
                HttpStatus.OK);
    }

    public ResponseEntity<List<Tag>> getAllTagsOfGroup(String group_name){
        return new ResponseEntity<List<Tag>>(
                this.tagRepo.findAllTagsOfGroup(group_name),
                HttpStatus.OK);
    }

}
