package com.reportscollector.demo.service;

import com.reportscollector.demo.repository.DataRepository;
import com.reportscollector.demo.model.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class DataService {

    @Autowired
    private DataRepository dataRepository;

    //Create operation
    public Data createReport(Data report){
            return dataRepository.save(report);
    }
    //Retrieve operation
    public List<Data> getAllReports(){
        return dataRepository.findAll();
    }

    public List<Data> getAllReportsById(String userKey){
        return dataRepository.findAllByUserKey(userKey);
    }


}
