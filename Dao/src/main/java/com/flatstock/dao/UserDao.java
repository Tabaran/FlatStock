package com.flatstock.dao;

import com.flatstock.model.User;

import java.util.List;

/**
 * Created by Valentin on 26.05.2015.
 */
public interface UserDao {
    List<User> getAllUsers();
    User getUser(Integer id);
    Integer addUser(User user);
    void updateUser(User user);
    void deleteUser(Integer id);
}