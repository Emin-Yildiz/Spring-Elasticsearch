package com.example.elasticsearch.service;

import com.example.elasticsearch.entities.User;
import com.example.elasticsearch.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Iterable<User> getAllUser(){
        return  userRepository.findAll();
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> findByNameLikeOrGender(String name, String gender){
        return userRepository.findByNameLikeOrGenderLike(name,gender);
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
