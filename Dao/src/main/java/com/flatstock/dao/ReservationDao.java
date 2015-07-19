package com.flatstock.dao;

import com.flatstock.model.IReservation;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 * Created by Valentin on 31.05.2015.
 */
public interface ReservationDao {
    List<IReservation> getAllReservation();
    IReservation getReservation(Integer id);
    void addReservation(IReservation reservation);
    void updateReservation(IReservation reservation);
    void deleteReservation(Integer id);
}
