package com.reportscollector.demo.service;

import com.reportscollector.demo.model.User;
import com.reportscollector.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired

    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public User findOne(String id){
        return userRepository.getById(id);
    }

}
