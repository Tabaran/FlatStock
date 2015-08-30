package com.flatstock.service.impl;

import com.flatstock.dao.UserDao;
import com.flatstock.dao.impl.UserDaoImpl;
import com.flatstock.model.IUser;
import com.flatstock.service.UserService;
import com.flatstock.service.exceptions.IncorrectLoginExceptions;

import java.io.InputStream;
import java.util.List;


/**
 * Created by Valentin on 11.07.2015.
 */
public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public List<IUser> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public IUser getUser(Integer id) {
        return userDao.getUser(id);
    }

    @Override
    public Integer addUser(IUser user) {
        return userDao.addUser(user);
    }

    @Override
    public void updateUser(IUser user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    @Override
    public void uploadPhotoToDB(Integer userId, InputStream stream, int size) {
        userDao.insertPhoto(userId, stream, size);
    }

    @Override
    public byte[] getPhoto(Integer userId) {
        return userDao.getPhoto(userId);
    }

    @Override
    public IUser validateUser(String login, String password) throws IncorrectLoginExceptions {
        for(IUser user: getAllUsers()){
            if(login.equals(user.getLogin()) && password.equals(user.getPassword()))
                return user;
        }
        throw new IncorrectLoginExceptions();
    }
}
