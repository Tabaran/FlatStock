package com.flatstock.dao;

import com.flatstock.model.IReservation;

import java.util.List;

/**
 * Created by Valentin on 31.05.2015.
 */
public interface ReservationDao {
    public List<IReservation> getAllReservation();
    public IReservation getReservation(Integer id);
    public void addReservation(IReservation reservation);
    public void updateReservation(IReservation reservation);
    public void deleteReservation(Integer id);
}
