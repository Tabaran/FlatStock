package com.flatstock.dao.impl;

import com.flatstock.dao.UsersPhotosDao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by vtabaran on 8/31/2015.
 */
public class UsersPhotosDaoImpl implements UsersPhotosDao {

    public static final String TABLE_NAME = "USERS_PHOTOS";
    public static final String USER_ID = "user_id";
    public static final String PHOTO = "photo";
    private static final String INSERT_PHOTO = "INSERT INTO " + TABLE_NAME + " VALUES (?, ?)";
    private static final String UPDATE_PHOTO = "UPDATE " + TABLE_NAME + " SET " + PHOTO + "=? WHERE " + USER_ID + "=?;";
    private static final String SELECT_PHOTO = "SELECT " + PHOTO  + " FROM " + TABLE_NAME + " WHERE " + USER_ID + "=?;";
    private static final String DELETE_PHOTO = "DELETE FROM " + TABLE_NAME + " WHERE " + USER_ID + "=?";

    @Override
    public void insertPhoto(final Integer userId, final InputStream inputStream, final int size) {
        Dao dao = new Dao() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setInt(1, userId.intValue());
                statement.setBinaryStream(2, inputStream, size);
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
    public void updatePhoto(final Integer userId, final InputStream inputStream, final int size) {
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
        dao.executeQuery(UPDATE_PHOTO);
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

    @Override
    public void deletePhoto(final Integer userId) {
        Dao dao = new Dao() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setInt(1, userId);
            }

            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        dao.executeQuery(DELETE_PHOTO);
    }
}
