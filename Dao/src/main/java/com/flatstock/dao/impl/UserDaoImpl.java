package com.flatstock.dao.impl;


import com.flatstock.dao.UserDao;
import com.flatstock.model.Gender;
import com.flatstock.model.IUser;
import com.flatstock.model.Role;
import com.flatstock.model.impl.User;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Valentin on 27.05.2015.
 */
public class UserDaoImpl implements UserDao {

    private static final String TABLE_NAME = "USERS";
    public static final String ID = "id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String GENDER = "gender";
    public static final String EMAIL = "email";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String ROLE = "role";
    public static final String PHOTO_URL = "photo_url";
    public static final String PHOTO = "photo";

    private static final String SELECT_ALL_QUERY = "SELECT * FROM "+TABLE_NAME;
    private static final String SELECT_BY_ID = "SELECT * FROM "+TABLE_NAME+" WHERE " +ID+ "=?";
    private static final String ADD_USER = "INSERT INTO "+TABLE_NAME+
            " (" + FIRST_NAME + ", " + LAST_NAME + ", " + GENDER+", "+ EMAIL+", "
            + LOGIN +", "+ PASSWORD+ ", " + ROLE +", "+ PHOTO_URL+")" +
            " VALUES (?, ?, ?::gender, ?, ?, ?, ?::role, ?) RETURNING id;";
    private static final String UPDATE_USER = "UPDATE "+TABLE_NAME+
            " SET " + FIRST_NAME+"=?, "+ LAST_NAME+"=?, "+ GENDER +"=?::gender, "+
            EMAIL+"=?, "+ LOGIN +"=?, " + PASSWORD + "=?, " + ROLE + "=?::role, " +
            PHOTO_URL + "=?" + " WHERE id=" + "?";
    private static final String DELETE_USER = "DELETE FROM " + TABLE_NAME + " WHERE " +ID + "=?";
    private static final String INSERT_PHOTO = "INSERT INTO " + TABLE_NAME + " (" + PHOTO + ") VALUES (?) WHERE " + ID + "=?;";
    private static final String SELECT_PHOTO = "SELECT " + PHOTO  + " FROM " + TABLE_NAME + " WHERE " + ID + "=?;";


    public List<IUser> getAllUsers() {
        Dao<List<IUser>> dao = new Dao<List<IUser>>() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {

            }

            @Override
            public List<IUser> execute(ResultSet result) throws SQLException {
                List<IUser> users = new ArrayList<IUser>();
                while (result.next()) {
                    IUser user = new User();
                    user.setId(result.getInt(ID));
                    user.setFirstName(result.getString(FIRST_NAME));
                    user.setLastName(result.getString(LAST_NAME));
                    user.setGender(Gender.fromString(result.getString(GENDER)));
                    user.setEmail(result.getString(EMAIL));
                    user.setLogin(result.getString(LOGIN));
                    user.setPassword(result.getString(PASSWORD));
                    user.setRole(Role.fromString(result.getString(ROLE)));
                    user.setPhotoUrl(result.getString(PHOTO_URL));
                    users.add(user);
                }
                return users;
            }
        };
        return dao.executeQuery(SELECT_ALL_QUERY);
    }

    public IUser getUser(final Integer id) {
        Dao<IUser> dao = new Dao<IUser>() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setInt(1, id);
            }

            @Override
            public IUser execute(ResultSet result) throws SQLException {
                IUser user = new User();
                if (!result.next()) return user;
                user.setId(result.getInt(ID));
                user.setFirstName(result.getString(FIRST_NAME));
                user.setLastName(result.getString(LAST_NAME));
                user.setGender(Gender.fromString(result.getString(GENDER)));
                user.setEmail(result.getString(EMAIL));
                user.setLogin(result.getString(LOGIN));
                user.setPassword(result.getString(PASSWORD));
                user.setRole(Role.fromString(result.getString(ROLE)));
                user.setPhotoUrl(result.getString(PHOTO_URL));
                return user;
            }
        };
        return dao.executeQuery(SELECT_BY_ID);
    }

    public Integer addUser(final IUser user) {
        Dao<Integer> dao = new Dao<Integer>() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setString(1, user.getFirstName());
                statement.setString(2, user.getLastName());
                statement.setString(3, user.getGender().toString());
                statement.setString(4, user.getEmail());
                statement.setString(5, user.getLogin());
                statement.setString(6, user.getPassword());
                statement.setString(7, user.getRole().toString());
                statement.setString(8, user.getPhotoUrl());
            }

            @Override
            public Integer execute(ResultSet result) throws SQLException {
                if(result.next()){
                    return result.getInt(ID);
                }
                return null;
            }
        };
        return dao.executeQuery(ADD_USER);
    }

    public void updateUser(final IUser user) {
        Dao dao = new Dao() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setString(1, user.getFirstName());
                statement.setString(2, user.getLastName());
                statement.setString(3, user.getGender().toString());
                statement.setString(4, user.getEmail());
                statement.setString(5, user.getLogin());
                statement.setString(6, user.getPassword());
                statement.setString(7, user.getRole().toString());
                statement.setString(8, user.getPhotoUrl());
                statement.setInt(9, user.getId());
            }

            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        dao.executeQuery(UPDATE_USER);
    }

    public void deleteUser(final Integer id) {
        Dao dao = new Dao() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setInt(1, id);
            }

            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        dao.executeQuery(DELETE_USER);
    }

    @Override
    public void insertPhoto(final Integer userId, final InputStream inputStream, final int size) {
        Dao dao = new Dao() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setBinaryStream(1, inputStream, size);
                statement.setInt(2, userId.intValue());
            }

            @Override
            public Object execute(ResultSet result) throws SQLException {
                if(inputStream != null){
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        };
        dao.executeQuery(INSERT_PHOTO);
    }

    @Override
    public byte[] getPhoto(final Integer userId) {
        Dao<byte[]> dao = new Dao<byte[]>() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setInt(1, userId);
            }

            @Override
            public byte[] execute(ResultSet result) throws SQLException {
                if(result.next()){
                    return result.getBytes(PHOTO);
                }
                return null;
            }
        };
        return dao.executeQuery(SELECT_PHOTO);
    }
}
