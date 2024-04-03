package com.pedrohenrique.workshopmongo.services;

import com.pedrohenrique.workshopmongo.domain.User;
import com.pedrohenrique.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
}
