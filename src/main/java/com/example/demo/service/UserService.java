package com.example.demo.service;



import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    User getUser(Long id);

}
