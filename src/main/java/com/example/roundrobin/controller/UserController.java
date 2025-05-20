package com.example.roundrobin.controller;

import com.example.roundrobin.model.User;
import com.example.roundrobin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/next")
    public User getNextUser() {
        return userService.getNextUser();
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
} 