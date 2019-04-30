package com.reportscollector.reportcollector.controller;


import com.reportscollector.reportcollector.service.DataService;
import com.reportscollector.reportcollector.model.Data;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
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
    public Data create(@Valid @RequestBody Data data, @PathVariable String userId) {
        if (data.getDuration() == null || data.getMedia_name() == null || data.getDisplayed_at() == 0) {
            return null;
        }
        data.setUser_key(userId);
        dataService.createReport(data);
        return data;
    }


    @GetMapping("getAllReports")
    public List<Data> getAll() {
        List<Data> data = dataService.getAllReports();
        if (data == null) {
            return null;
        }
        return data;
    }


    @GetMapping("{userKey}/getAllReports")
    public List<Data> getAllByUserKey(@PathVariable String userKey) {
        List<Data> data = dataService.getAllReportsById(userKey);
        if (data == null) {
            return null;
        }
        return data;
    }


    @GetMapping("{fromTime}/{toTime}/getAllReportsByTime")
    public List<Data> getAllByTime(@PathVariable Long fromTime, @PathVariable Long toTime) {
        List<Data> data = dataService.getAllReports();
        if (data == null) {
            return null;
        }
        ArrayList<Data> newList = new ArrayList<>();
        for (Data data1 : data) {
            if (data1.getDisplayed_at() < toTime && data1.getDisplayed_at() > fromTime) {
                newList.add(data1);
            }
        }
        return newList;
    }

}





