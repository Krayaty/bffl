package org.bffl.controller;

import org.bffl.dao.model.App_user;
import org.bffl.dao.repo.App_userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    App_userRepo app_userRepo;

    @GetMapping("/App_users")
    public ResponseEntity<List<App_user>> getAllUsers() {
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
    /*
    @GetMapping("/App_users/{id}")
    public ResponseEntity<App_user> getUserById(@PathVariable("id") long id) {
        Optional<App_user> App_userData = app_userRepo.findById(id);

        if (App_userData.isPresent()) {
            return new ResponseEntity<>(App_userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/App_users")
    public ResponseEntity<App_user> createUser(@RequestBody App_user App_user) {
        try {
            App_user _App_user = app_userRepo
                    .save(new App_user(App_user.getTitle(), App_user.getDescription(), false));
            return new ResponseEntity<>(_App_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/App_users/{id}")
    public ResponseEntity<App_user> updateUser(@PathVariable("id") long id, @RequestBody App_user App_user) {
        Optional<App_user> App_userData = app_userRepo.findById(id);

        if (App_userData.isPresent()) {
            App_user _App_user = App_userData.get();
            _App_user.setTitle(App_user.getTitle());
            _App_user.setDescription(App_user.getDescription());
            _App_user.setPublished(App_user.isPublished());
            return new ResponseEntity<>(app_userRepo.save(_App_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/App_users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
        try {
            app_userRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/App_users")
    public ResponseEntity<HttpStatus> deleteAllUsers() {
        try {
            app_userRepo.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/App_users/name")
    public ResponseEntity<List<App_user>> findByName() {
        try {
            List<App_user> App_users = app_userRepo.findByPublished(true);

            if (App_users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(App_users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    */
}
