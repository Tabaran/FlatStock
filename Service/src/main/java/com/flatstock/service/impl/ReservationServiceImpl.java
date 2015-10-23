package com.flatstock.service.impl;

import com.flatstock.dao.ReservationDao;
import com.flatstock.model.Reservation;
import com.flatstock.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * Created by Valentin on 11.07.2015.
 */
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationDao reservationDao;

    public List<Reservation> getAllReservation() {
        return reservationDao.getAllReservation();
    }

    public Reservation getReservation(Integer id) {
        return reservationDao.getReservation(id);
    }

    public void addReservation(Reservation reservation) {
        reservationDao.addReservation(reservation);
    }

    public void updateReservation(Reservation reservation) {
        reservationDao.updateReservation(reservation);
    }

    public void deleteReservation(Integer id) {
        reservationDao.deleteReservation(id);
    }
}
