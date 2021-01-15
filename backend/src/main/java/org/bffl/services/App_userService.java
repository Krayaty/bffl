package org.bffl.services;

import org.bffl.dao.model.App_user;
import org.bffl.dao.repo.App_userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class App_userService {

    @Autowired
    App_userRepo app_userRepo;

    public ResponseEntity<List<App_user>> findAll() {
        try {

            List<App_user> app_users = new ArrayList<App_user>();
            app_userRepo.findAll().forEach(app_users::add);

            if (app_users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(app_users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<App_user> findById(long id) {
        Optional<App_user> App_userData = app_userRepo.findById(id);

        if (App_userData.isPresent()) {
            return new ResponseEntity<>(App_userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<App_user> create(App_user app_user) {
        try {
            App_user _App_user = app_userRepo
                    .save(new App_user(app_user.getEmail(), app_user.getFName(), app_user.getSName(), app_user.getPw()));
            return new ResponseEntity<>(_App_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<App_user> update(long id, App_user app_user) {
        Optional<App_user> App_userData = app_userRepo.findById(id);

        if (App_userData.isPresent()) {
            App_user _App_user = App_userData.get();
            _App_user.setEmail(app_user.getEmail());
            _App_user.setFName(app_user.getFName());
            _App_user.setSName(app_user.getSName());
            _App_user.setPw(app_user.getPw());
            return new ResponseEntity<>(app_userRepo.save(_App_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> delete(long id) {
        try {
            app_userRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> deleteAll() {
        try {
            app_userRepo.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
