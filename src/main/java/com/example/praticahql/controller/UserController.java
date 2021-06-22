package com.example.praticahql.controller;


import com.example.praticahql.model.User;
import com.example.praticahql.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> findAllUser(){
        return userService.findAllUser();
    }

    @GetMapping("/findName/{s}")
    public List<User> findByUserNameContains(@PathVariable String s){
        return userService.findByUserNameContains(s);
    }

    @GetMapping("/findId/{id}")
    public List<User> findStudents(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @PostMapping("/create")
    public Object createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PutMapping("/edit/{id}")
    public void updateUserPassword(@RequestBody User user, @PathVariable Long id){
        userService.updateUserPassword(id, user.getPassword());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id){
        userService.deleteUser(id);
    }



}
