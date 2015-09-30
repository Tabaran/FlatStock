package com.flatstock.dao;

import java.io.InputStream;

/**
 * Created by vtabaran on 8/31/2015.
 */
public interface UsersPhotosDao {
    void insertPhoto(Integer userId, InputStream inputStream, int size);
    void updatePhoto(Integer userId, InputStream inputStream, int size);
    byte[] getPhoto(Integer userId);
    void deletePhoto(Integer userId);
}
