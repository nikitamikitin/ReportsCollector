package com.reportscollector.reportcollector.controller;

import com.reportscollector.reportcollector.model.User;
import com.reportscollector.reportcollector.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

public class UserControllerTest {


    @Mock
    private UserService userService;
    @InjectMocks
    UserController sut;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void createUser() {
        User user = new User();
        user.setEmail("test@com.com");
        user.setPassword("123456");
        when(userService.createUser(user)).thenReturn(user);
        ResponseEntity<User> user1 = sut.createUser(user);
        verify(userService).createUser(user1.getBody());
        assertEquals("test@com.com", user1.getBody().getEmail());
    }


    @Test
    public void getUser() {
        User user = new User();
        user.setEmail("test@com.com");
        user.setPassword("123456");
        when(userService.findByEmail("test@com.com")).thenReturn(user);

        User user1 = sut.getUser("test@com.com");
        verify(userService).findByEmail("test@com.com");
        assertEquals("test@com.com", user1.getEmail());

    }


    @Test
    public void getUserById() {
        User user = new User();
        user.setId("testId");
        when(userService.findOne("testId")).thenReturn(user);
        User user1 = sut.getUserById("testId");
        verify(userService).findOne("testId");
        assertEquals("testId", user1.getId());
    }

    @Test
    public void loginUser() {
        User user = new User();
        user.setEmail("test@com.com");
        user.setPassword("123456");
        when(userService.findByEmail("test@com.com")).thenReturn(user);
        User userTest = new User();
        userTest.setEmail("test@com.com");
        userTest.setPassword("123456");
        User user1 = sut.loginUser(userTest);
        verify(userService).findByEmail("test@com.com");
        assertEquals("test@com.com", user1.getEmail());
    }
}