package org.bffl.dbConnector.controller;

import org.bffl.dbConnector.dao.model.App_user;
import org.bffl.dbConnector.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class MainController {

    //controller für die WebApp

    @Autowired
    AppService app_Service;

    @GetMapping("/App_users")
    public ResponseEntity<List<App_user>> getAllUsers() {
        return app_Service.findAll();
    }

    @GetMapping("/App_users/{id}")
    public ResponseEntity<App_user> getUserById(@PathVariable("id") String id) {
        return app_Service.findById(id);
    }

    @PutMapping("/App_users/{id}")
    public ResponseEntity<App_user> updateUser(@PathVariable("id") String id, @RequestBody App_user app_user) {
        return app_Service.update(id, app_user);
    }

    @DeleteMapping("/App_users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") String id) {
        return app_Service.delete(id);
    }

    @DeleteMapping("/App_users")
    public ResponseEntity<HttpStatus> deleteAllUsers() {
        return app_Service.deleteAll();
    }

}
