package com.flatstock.repository;

import com.flatstock.dao.ReservationDao;
import com.flatstock.model.Reservation;

import java.util.List;

/**
 * Created by Valentin on 22.10.2015.
 */
public class ReservationRepository implements ReservationDao {
    @Override
    public List<Reservation> getAllReservation() {
        return null;
    }

    @Override
    public Reservation getReservation(Integer id) {
        return null;
    }

    @Override
    public void addReservation(Reservation reservation) {

    }

    @Override
    public void updateReservation(Reservation reservation) {

    }

    @Override
    public void deleteReservation(Integer id) {

    }
}
