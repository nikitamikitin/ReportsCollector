package com.reportscollector.reportcollector.service;

import com.reportscollector.reportcollector.repository.DataRepository;
import com.reportscollector.reportcollector.model.Data;
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
