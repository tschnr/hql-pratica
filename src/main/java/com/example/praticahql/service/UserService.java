package com.example.praticahql.service;

import com.example.praticahql.model.User;
import com.example.praticahql.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAllUser(){
        return userRepository.findAllUsers();
    }

    public List<User> findByUserNameContains(String s){
        return userRepository.findByUserNameContains(s);
    }

    public List<User> findUserById(Long id){
        return userRepository.findUserById(id);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteUser(id);
    }

    public void updateUserPassword(Long id, String password){
         userRepository.updateUserPassword(password, id);

    }



}
