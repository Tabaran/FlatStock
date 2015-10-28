package com.flatstock.dao;

import com.flatstock.model.Reservation;

import java.util.List;

/**
 * Created by Valentin on 31.05.2015.
 */
public interface ReservationDao {
    List<Reservation> getAllReservation();
    Reservation getReservation(Integer id);
    Integer addReservation(Reservation reservation);
    void updateReservation(Reservation reservation);
    void deleteReservation(Integer id);
}
