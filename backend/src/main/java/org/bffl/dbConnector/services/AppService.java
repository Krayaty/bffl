package org.bffl.dbConnector.services;

import org.bffl.dbConnector.dao.model.Target_url;
import org.bffl.dbConnector.dao.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Service
public class AppService {

    @Autowired
    private App_groupRepo app_groupRepo;

    @Autowired
    private App_userRepo app_userRepo;

    @Autowired
    private Available_protocollsRepo available_protocollsRepo;

    @Autowired
    private CredentialRepo credentialRepo;

    @Autowired
    private Short_urlRepo short_urlRepo;

    @Autowired
    private TagRepo tagRepo;

    @Autowired
    private Target_urlRepo target_urlRepo;

    @Autowired
    private Url_callRepo url_callRepo;

    @Autowired
    private Url_has_tagsRepo url_has_tagsRepo;

    @Autowired
    private Url_historyRepo url_historyRepo;

    @Autowired
    private User_has_groupRepo user_has_groupRepo;

    @RolesAllowed("APP-User")
    public ResponseEntity<List<Target_url>> findAllTarget_urls(){
        return new ResponseEntity<List<Target_url>>(this.target_urlRepo.findAll(), HttpStatus.OK);
    }

}
