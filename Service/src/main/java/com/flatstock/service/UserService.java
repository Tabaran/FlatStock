package com.flatstock.service;

import com.flatstock.model.IUser;

import java.util.List;

/**
 * Created by Valentin on 11.07.2015.
 */
public interface UserService {
    public List<IUser> getAllUsers();
    public IUser getUser(Integer id);
    public void addUser(IUser user);
    public void updateUser(IUser user);
    public void deleteUser(Integer id);
}
