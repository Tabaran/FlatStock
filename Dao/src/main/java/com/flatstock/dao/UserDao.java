package com.flatstock.dao;

import com.flatstock.model.IUser;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 * Created by Valentin on 26.05.2015.
 */
public interface UserDao {
    List<IUser> getAllUsers();
    IUser getUser(Integer id);
    void addUser(IUser user);
    void updateUser(IUser user);
    void deleteUser(Integer id);
}