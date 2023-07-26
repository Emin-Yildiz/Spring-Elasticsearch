package com.example.elasticsearch.controller;

import co.elastic.clients.elasticsearch.ml.Page;
import com.example.elasticsearch.entities.User;
import com.example.elasticsearch.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public Iterable<User> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser()).getBody();
    }

    @GetMapping("/{search}")
    public List<User> getUserByNameLikeOrGender(@PathVariable String search){
        return new ResponseEntity<>(userService.findByNameLikeOrGender(search,search),HttpStatus.FOUND).getBody();
    }

    @PostMapping()
    public User addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED).getBody();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
