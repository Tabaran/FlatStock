package com.flatstock.dao;

import java.sql.ResultSet;
import java.util.Map;

/**
 * Created by Valentin on 31.05.2015.
 */
public interface ReservationDao {
    ResultSet getAllReservation();
    ResultSet getReservation(Integer id);
    void addReservation(Map<String, String> params);
    void updateReservation(Map<String, String> params);
    void deleteReservation(Integer id);
}
