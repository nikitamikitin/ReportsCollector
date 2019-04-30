package com.reportscollector.reportcollector.controller;

import static org.junit.Assert.*;
import com.reportscollector.reportcollector.model.Data;
import com.reportscollector.reportcollector.service.DataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DataControllerTest {


    @Mock
    private DataService dataService;
    @InjectMocks
    DataController sut;


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getAll() {
        List<Data> dataList =new ArrayList<>();
        Data data1=new Data();
        dataList.add(data1);
        when(dataService.getAllReports()).thenReturn(dataList);
        //testing
        List<Data> newList=sut.getAll();
        //validate
        verify(dataService).getAllReports();
        for(Data data: newList){
            data.equals(data1);
        }
    }

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

    @Test
    public void getAllByTime(){
        List<Data> data =new ArrayList<>();
        Data data1=new Data();
        data1.setDisplayed_at(1L);
        data.add(data1);
        when(dataService.getAllReports()).thenReturn(data);
        List<Data> dataList=sut.getAllByTime(1L,2L);
        verify(dataService).getAllReports();
        for(Data data2:dataList){
                assertTrue(data2.getDisplayed_at()>1L && data2.getDisplayed_at()<2L);

        }
    }


    @Test
    public void create(){
        Data data=new Data();
        data.setDisplayed_at(1L);
        data.setMedia_name("test");
        data.setDuration("3.22");
        data.setUser_key("hellotest123");
        when(dataService.createReport(data)).thenReturn(data);
        Data data1 =sut.create(data ,"hellotest123");
        verify(dataService).createReport(data1);
        assertEquals("hellotest123",data1.getUser_key());
    }
}