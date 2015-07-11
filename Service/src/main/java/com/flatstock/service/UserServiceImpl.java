package com.flatstock.service;

import com.flatstock.dao.UserDao;
import com.flatstock.dao.UserDaoImpl;
import com.flatstock.model.Gender;
import com.flatstock.model.IUser;
import com.flatstock.model.User;
import static com.flatstock.dao.UserDaoImpl.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Valentin on 11.07.2015.
 */
public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    public List<IUser> getAllUsers() {
        ResultSet result = userDao.getAllUsers();
        List<IUser> users = new ArrayList<IUser>();
        try {
            while (result.next()){
                IUser user = new User();
                user.setId(result.getInt(ID));
                user.setFirstName(result.getString(FIRST_NAME));
                user.setLastName(result.getString(LAST_NAME));
                user.setGender(Gender.fromBoolean(result.getBoolean(GENDER)));
                user.setEmail(result.getString(EMAIL));
                user.setLogin(result.getString(LOGIN));
                user.setPassword(result.getString(PASSWORD));
                user.setPhotoUrl(result.getString(PHOTO_URL));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public IUser getUser(Integer id) {
        ResultSet result = userDao.getUser(id);
        IUser user = new User();
        try {
            if(!result.next())return null;
            user.setId(result.getInt(ID));
            user.setFirstName(result.getString(FIRST_NAME));
            user.setLastName(result.getString(LAST_NAME));
            user.setGender(Gender.fromBoolean(result.getBoolean(GENDER)));
            user.setEmail(result.getString(EMAIL));
            user.setLogin(result.getString(LOGIN));
            user.setPassword(result.getString(PASSWORD));
            user.setPhotoUrl(result.getString(PHOTO_URL));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void addUser(IUser user) {
        Map<String, String> params = new HashMap<String, String>();
        params.put(FIRST_NAME, user.getFirstName());
        params.put(LAST_NAME, user.getLastName());
        params.put(EMAIL, user.getEmail());
        params.put(LOGIN, user.getLogin());
        params.put(PASSWORD, user.getPassword());
        params.put(PHOTO_URL, user.getPhotoUrl());
        params.put(GENDER, String.valueOf(Gender.toBoolean(user.getGender())));
        userDao.addUser(params);
    }

    public void updateUser(IUser user) {
        Map<String, String> params = new HashMap<String, String>();
        params.put(ID, user.getId().toString());
        params.put(FIRST_NAME, user.getFirstName());
        params.put(LAST_NAME, user.getLastName());
        params.put(EMAIL, user.getEmail());
        params.put(LOGIN, user.getLogin());
        params.put(PASSWORD, user.getPassword());
        params.put(PHOTO_URL, user.getPhotoUrl());
        params.put(GENDER, String.valueOf(Gender.toBoolean(user.getGender())));
        userDao.addUser(params);
    }

    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }
}
