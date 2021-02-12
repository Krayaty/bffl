package org.bffl.dbConnector.services;

import org.bffl.dbConnector.dao.repos.*;
import org.bffl.dbConnector.dao.model.App_user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppService {

    @Autowired
    private App_groupRepo app_groupRepo;

    @Autowired
    private App_userRepo app_userRepo;

    public ResponseEntity<List<App_user>> findAll() {
        try {

            List<App_user> app_users = new ArrayList<App_user>();
            app_userRepo.findAll().forEach(user -> {
                if(user.getRealm_id().equals("BFFL-Realm")) app_users.add(user);
            });

            if (app_users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(app_users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<App_user> findById(String id) {
        Optional<App_user> App_userData = app_userRepo.findById(id).filter(user -> {
            if(user.getRealm_id().equals("BFFL-Realm")) return true;
            return false;
        });

        if (App_userData.isPresent()) {
            return new ResponseEntity<>(App_userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<App_user> update(String id, App_user app_user) {
        Optional<App_user> App_userData = app_userRepo.findById(id).filter(user -> {
            if(user.getRealm_id().equals("BFFL-Realm")) return true;
            return false;
        });

        if (App_userData.isPresent()) {
            App_user _App_user = App_userData.get();
            _App_user.setEmail(app_user.getEmail());
            _App_user.setFirst_name(app_user.getFirst_name());
            _App_user.setLast_name(app_user.getLast_name());
            return new ResponseEntity<>(app_userRepo.save(_App_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> delete(String id) {
        if(app_userRepo.findById(id).get().getRealm_id().equals("BFFL-Relam")){
            try {
                app_userRepo.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> deleteAll() {
        List<App_user> users = findAll().getBody();
        for(App_user user: users){
            if(user.getRealm_id().equals("BFFL-Realm")){
                try {
                    delete(user.getId());
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Autowired
    private Available_protocollsRepo available_protocollsRepo;

    @Autowired
    private CredentialRepo credentialRepo;

    @Autowired
    private ProtocollsRepo protocollsRepo;

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

}
