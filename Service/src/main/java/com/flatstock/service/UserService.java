package com.flatstock.service;

import com.flatstock.model.IUser;
import com.flatstock.service.exceptions.IncorrectLoginExceptions;

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Valentin on 11.07.2015.
 */
public interface UserService {
    List<IUser> getAllUsers();
    IUser getUser(Integer id);
    Integer addUser(IUser user);
    void updateUser(IUser user);
    void deleteUser(Integer id);

    void showPhoto(Integer userId, String path, BufferedOutputStream output);

    void uploadPhotoToDB(Integer userId, InputStream stream, int size);
    byte[] getPhoto(Integer userId);
    IUser validateUser(String login, String password) throws IncorrectLoginExceptions;
}
