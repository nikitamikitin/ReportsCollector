package com.reportscollector.reportcollector.controller;

import com.reportscollector.reportcollector.model.User;
import com.reportscollector.reportcollector.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

public class UserControllerTest {


    @Mock
    private UserService userService;
    @InjectMocks
    UserController sut;


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }



////    @Test
//    public void create(){
//        Data data=new Data();
//        data.setDisplayed_at(1L);
//        data.setMedia_name("test");
//        data.setDuration("3.22");
//        data.setUser_key("hellotest123");
//        when(dataService.createReport(data)).thenReturn(data);
//        Data data1 =sut.create(data ,"hellotest123");
//        verify(dataService).createReport(data1);
//        assertEquals("hellotest123",data1.getUser_key());
//    }

    @Test
    public void createUser() {
        User user =new User();
        user.setEmail("test@com.com");
        user.setPassword("123456");
        when(userService.createUser(user)).thenReturn(user);
        User user1=sut.createUser(user);
        verify(userService).createUser(user1);
        assertEquals("test@com.com",user1.getEmail());
    }

    @Test
    public void getUser() {
    }

    @Test
    public void getUserById() {
    }

    @Test
    public void loginUser() {
    }
}