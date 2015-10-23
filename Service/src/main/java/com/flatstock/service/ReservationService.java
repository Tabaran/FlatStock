package com.flatstock.service;

import com.flatstock.model.Reservation;

import java.util.List;

/**
 * Created by Valentin on 11.07.2015.
 */
public interface ReservationService {
    List<Reservation> getAllReservation();
    Reservation getReservation(Integer id);
    void addReservation(Reservation reservation);
    void updateReservation(Reservation reservation);
    void deleteReservation(Integer id);
}
