package com.reportscollector.reportcollector.controller;

import com.reportscollector.reportcollector.model.User;
import com.reportscollector.reportcollector.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping(value = "createUser")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        if (user == null || user.getEmail() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (userService.findByEmail(user.getEmail()) != null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);//user already exists
        }
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }

    @GetMapping(value = "/{email}/getUserByEmail")
    public User getUser(@PathVariable String email) {
        User user = userService.findByEmail(email);
        if (user == null) {
            return null;
        }
        return user;

    }


    @GetMapping(value = "/{id}/getUserById")
    public User getUserById(@PathVariable String id) {
        User user = userService.findOne(id);
        if (user == null) {
            return null;
        }
        return user;
    }


    @PostMapping(value = "login")
    public User loginUser(@Valid @RequestBody User user) {
        if (user == null || user.getEmail() == null) {
            return null;
        }
        User newUser = userService.findByEmail(user.getEmail());
        if (newUser.getEmail().equals(user.getEmail()) && newUser.getPassword().equals(user.getPassword())) {

            return newUser;
        }
        return null;
    }


}



