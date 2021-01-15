package org.bffl.controller;

import org.bffl.dao.model.App_user;
import org.bffl.services.App_userService;
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

    @Autowired
    App_userService app_userService;

    @GetMapping("/App_users")
    public ResponseEntity<List<App_user>> getAllUsers() {
        return app_userService.findAll();
    }

    @GetMapping("/App_users/{id}")
    public ResponseEntity<App_user> getUserById(@PathVariable("id") long id) {
        return app_userService.findById(id);
    }

    @PostMapping("/App_users")
    public ResponseEntity<App_user> createUser(@RequestBody App_user app_user) {
        return app_userService.create(app_user);
    }

    @PutMapping("/App_users/{id}")
    public ResponseEntity<App_user> updateUser(@PathVariable("id") long id, @RequestBody App_user app_user) {
        return app_userService.update(id, app_user);
    }

    @DeleteMapping("/App_users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
        return app_userService.delete(id);
    }

    @DeleteMapping("/App_users")
    public ResponseEntity<HttpStatus> deleteAllUsers() {
        return app_userService.deleteAll();
    }

}
