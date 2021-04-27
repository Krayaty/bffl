package org.bffl.dbConnector.services;

import org.bffl.dbConnector.dao.model.Assigned_target;
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

    public ResponseEntity<List<Assigned_target>> findAllTargetURLs() {
        return new ResponseEntity<List<Assigned_target>>(this.assigned_targetRepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<Object>> getAllShortURLsWithCurrentTargetByGroupId(String group_id) {
        System.out.println(group_id);
        return new ResponseEntity<List<Object>>(
                this.short_urlRepo.findAllShortURLsWithCurrentTargetByGroupName(group_id),
                HttpStatus.OK);
    }

    public ResponseEntity<List<Object>> getAllGroupsOfGivenUser(String user_id) {
        return new ResponseEntity<List<Object>>(
                this.user_has_groupRepo.findAlLGroupsOfGivenUser(user_id),
                HttpStatus.OK);
    }

}
