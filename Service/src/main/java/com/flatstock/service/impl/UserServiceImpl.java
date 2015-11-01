package com.flatstock.service.impl;

import com.flatstock.dao.UserDao;
import com.flatstock.dao.UsersPhotosDao;
import com.flatstock.model.User;
import com.flatstock.repository.UserRepository;
import com.flatstock.service.UserService;
import com.flatstock.service.exceptions.IncorrectLoginExceptions;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Valentin on 11.07.2015.
 */
@Transactional
public class UserServiceImpl implements UserService {
    Logger LOG = Logger.getLogger(UserServiceImpl.class.getName());

    @Autowired
    UserDao userDao;

    UsersPhotosDao photosDao;

    private static Map<Integer, byte[]> photos = new HashMap<>();

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }

    @Override
    public Integer addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        photosDao.deletePhoto(id);
        userDao.deleteUser(id);
    }

    @Override
    public void showPhoto(Integer userId, String path, BufferedOutputStream output){
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            if ("DB".equals(path)) {

                byte[] data = getPhoto(userId);
                for (int i = 0; i < data.length; i++) {
                    output.write(data[i]);
                }
            } else {
                File photo = new File(path);
                fis = new FileInputStream(photo);
                bis = new BufferedInputStream(fis);
                for (int data; (data = bis.read()) > -1; ) {
                    output.write(data);
                }
            }
        } catch (IOException e) {
            LOG.error(e);
        } finally {
             try {
                 if (fis != null) fis.close();
                if (bis != null) bis.close();
                if (output != null) output.close();
            } catch (IOException e) {
                 LOG.error(e);
            }

        }
    }

    @Override
    public void uploadPhotoToDB(Integer userId, InputStream stream, int size) {
        photosDao.insertPhoto(userId, stream, size);
    }

    @Override
    public void updatePhotoInDB(Integer userId, InputStream stream, int size) {
        try {
            photos.put(userId, IOUtils.toByteArray(stream));
        } catch (IOException e) {
            LOG.error(e);
        }
        photosDao.updatePhoto(userId, stream, size);
    }

    @Override
    public byte[] getPhoto(Integer userId) {
        if(photos.get(userId) == null) photos.put(userId, photosDao.getPhoto(userId));
        return photos.get(userId);
    }

    @Override
    public User validateUser(String login, String password) throws IncorrectLoginExceptions {
        for(User user: getAllUsers()){
            if(login.equals(user.getLogin()) && password.equals(user.getPassword()))
                return user;
        }
        throw new IncorrectLoginExceptions();
    }
}
