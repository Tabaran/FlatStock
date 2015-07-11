package com.flatstock.dao;

import java.sql.ResultSet;
import java.util.Map;

/**
 * Created by Valentin on 26.05.2015.
 */
public interface UserDao {
    ResultSet getAllUsers();
    ResultSet getUser(Integer id);
    void addUser(Map<String, String> params);
    void updateUser(Map<String, String> params);
    void deleteUser(Integer id);
}