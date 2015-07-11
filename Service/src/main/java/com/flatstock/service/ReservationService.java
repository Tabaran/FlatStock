package com.flatstock.service;

import com.flatstock.model.IReservation;

import java.util.List;

/**
 * Created by Valentin on 11.07.2015.
 */
public interface ReservationService {
    List<IReservation> getAllReservation();
    IReservation getReservation(Integer id);
    void addReservation(IReservation reservation);
    void updateReservation(IReservation reservation);
    void deleteReservation(Integer id);
}
