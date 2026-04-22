package com.praktikumDB.deploy.controller;

import com.praktikumDB.deploy.model.User;
import com.praktikumDB.deploy.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userServices) {
        this.userService = userServices;
    }


    @PostMapping
    public String createUser(@RequestBody User request) {
        userService.addUser(request);
        return "user created successfully";
    }

    @GetMapping
    public List<User> getAllUser(){
    return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @DeleteMapping ("/{id}")
    public String deleteUser (@PathVariable String id){
        userService.deleteUser(id);
        return "user deleted sucessfully";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable String id,@RequestBody User request){
        userService.updateUser(id, request);
        return "user updated sucessfully";
    }
}
