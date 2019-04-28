package com.reportscollector.demo.controller;

import com.reportscollector.demo.model.User;
import com.reportscollector.demo.service.UserService;
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
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        if(user==null || user.getEmail()==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(userService.findByEmail(user.getEmail())!=null){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);//user already exists
        }
         return new  ResponseEntity<>(userService.createUser(user),HttpStatus.OK);
    }

    @GetMapping(value = "/{email}/getUserByEmail")
    public  ResponseEntity getUser(@PathVariable String email){
        User user=userService.findByEmail(email);
        if(user==null){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);//user is not exists in db
        }
        return new ResponseEntity<>(user,HttpStatus.OK);

    }
    @GetMapping(value = "/{id}/getUserById")
    public ResponseEntity<User> getUserById(@PathVariable String id){
        User user =userService.findOne(id);
        if(user==null){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);//user is not exists in db
        }
        return new ResponseEntity<> (user,HttpStatus.OK);
    }
}



