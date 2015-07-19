package com.flatstock.service;

import com.flatstock.dao.UserDao;
import com.flatstock.dao.UserDaoImpl;
import com.flatstock.model.IUser;
import java.util.List;


/**
 * Created by Valentin on 11.07.2015.
 */
public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    public List<IUser> getAllUsers() {
        return userDao.getAllUsers();
    }

    public IUser getUser(Integer id) {
        return userDao.getUser(id);
    }

    public void addUser(IUser user) {
        userDao.addUser(user);
    }

    public void updateUser(IUser user) {
        userDao.updateUser(user);
    }

    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }
}
