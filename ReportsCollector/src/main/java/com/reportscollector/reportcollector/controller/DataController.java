package com.reportscollector.reportcollector.controller;


import com.reportscollector.reportcollector.service.DataService;
import com.reportscollector.reportcollector.model.Data;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class DataController {

    @Autowired
    private DataService dataService;


    @PostMapping("/{userId}/collector/report")
    public ResponseEntity<Data> create(@Valid @RequestBody Data data,@PathVariable String userId) {
        if (data.getDuration() == null || data.getMedia_name() == null || data.getDisplayed_at()==0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        data.setUser_key(userId);
        dataService.createReport(data);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("getAllReports")
    public ResponseEntity getAll() {
        List<Data> data = dataService.getAllReports();
        if(data==null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @GetMapping("{userKey}/getAllReports")
    public ResponseEntity getAllByUserKey(@PathVariable String userKey) {
        List<Data> data = dataService.getAllReportsById(userKey);
        if(data==null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @GetMapping("{fromTime}/{toTime}/getAllReportsByTime")
    public ResponseEntity getAllByTime(@PathVariable String fromTime,@PathVariable String toTime) {
        List<Data> data = dataService.getAllReports();
        if(data==null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Long fT=Long.valueOf(fromTime);
        Long tT=Long.valueOf(toTime);
        for(Data data1: data){
            if (data1.getDisplayed_at()<tT &&data1.getDisplayed_at()>fT){
                ArrayList<Data> newList=new ArrayList<>();
                newList.add(data1);
                return new ResponseEntity<>(newList,HttpStatus.OK);
            };
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
