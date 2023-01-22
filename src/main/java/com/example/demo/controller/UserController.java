package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
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

    @GetMapping
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    User getUserById(@PathVariable(value = "id") int id) {
        return userService.getUserById(id);
    }

    @PostMapping(consumes = "application/json")
    void addUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @DeleteMapping("/{id}")
    void deleteUserById(@PathVariable(value = "id") int id) {
        userService.deleteUserById(id);
    }
}