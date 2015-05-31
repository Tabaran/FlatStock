package com.flatstock.dao;

import com.flatstock.model.IUser;
import com.flatstock.model.IUser;

import java.util.List;

/**
 * Created by Valentin on 26.05.2015.
 */
public interface UserDao {
    public List<IUser> getAllUsers();
    public IUser getUser(Integer id);
    public void addUser(IUser User);
    public void updateUser(IUser User);
    public void deleteUser(Integer id);
}
