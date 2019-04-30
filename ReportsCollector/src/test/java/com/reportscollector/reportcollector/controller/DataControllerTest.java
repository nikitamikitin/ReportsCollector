package com.reportscollector.reportcollector.controller;

import static org.junit.Assert.*;
import com.google.common.collect.ImmutableList;
import com.reportscollector.reportcollector.model.Data;
import com.reportscollector.reportcollector.repository.DataRepository;
import com.reportscollector.reportcollector.service.DataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DataControllerTest {
//    @Mock
//    private DataService dataService;

    @Mock
    private DataService dataService;
    @InjectMocks
    DataController sut;


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }


//    @Test
//    public void getAll() {
//        //prepare
//        when(dataService.getAllReports()).thenReturn(ImmutableList.of());
//        //testing
//        ResponseEntity dataList= sut.getAll();
//        //validate
//        verify(dataService).getAllReports();
//    }

    @Test
    public void getAllByUserKey(){
        List<Data> data = new ArrayList<>();
        Data data1=new Data();
        data1.setUser_key("1L");
        data.add(data1);
        when(dataService.getAllReportsById("1L")).thenReturn(data);

        List<Data> dataList=sut.getAllByUserKey("1L");
        verify(dataService).getAllReportsById("1L");
        for(Data data2:dataList){
            assertEquals("1L",data2.getUser_key());
        }

    }
}