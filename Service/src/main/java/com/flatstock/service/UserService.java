package com.flatstock.service;

import com.flatstock.model.IUser;
import com.flatstock.service.exceptions.IncorrectLoginExceptions;

import java.util.List;

/**
 * Created by Valentin on 11.07.2015.
 */
public interface UserService {
    List<IUser> getAllUsers();
    IUser getUser(Integer id);
    void addUser(IUser user);
    void updateUser(IUser user);
    void deleteUser(Integer id);
    IUser validateUser(String login, String password) throws IncorrectLoginExceptions;
}
