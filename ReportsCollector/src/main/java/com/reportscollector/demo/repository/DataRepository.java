package com.reportscollector.demo.repository;

import com.reportscollector.demo.model.Data;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DataRepository extends MongoRepository<Data, String> {

    Data save(Data data);
    List<Data> findAll();
    List<Data> findAllByUserKey(String userKey);
}
