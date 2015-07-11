package com.flatstock.dao;

import java.sql.ResultSet;
import java.util.Map;

/**
 * Created by Valentin on 26.05.2015.
 */
public interface ApartmentDao {
    ResultSet getAllApartments();
    ResultSet getApartmentsByOwnerId(Integer OwnerId);
    ResultSet getApartment(Integer id);
    void addApartment(Map<String, String> params);
    void updateApartment(Map<String, String> params);
    void deleteApartment(Integer id);
}
