package com.tarka.tarka.services;

import com.tarka.tarka.model.User;
import com.tarka.tarka.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements Serializable {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findByID(Long id){
        Optional<User> optionalUser = repository.findById(id);
        return optionalUser.get();
    }


}
