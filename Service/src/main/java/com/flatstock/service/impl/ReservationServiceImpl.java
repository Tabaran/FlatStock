package com.flatstock.service.impl;

import com.flatstock.dao.ReservationDao;
import com.flatstock.dao.impl.ReservationDaoImpl;
import com.flatstock.model.IReservation;
import com.flatstock.service.ReservationService;

import java.util.List;


/**
 * Created by Valentin on 11.07.2015.
 */
public class ReservationServiceImpl implements ReservationService {

    ReservationDao reservationDao = new ReservationDaoImpl();

    public List<IReservation> getAllReservation() {
        return reservationDao.getAllReservation();
    }

    public IReservation getReservation(Integer id) {
        return reservationDao.getReservation(id);
    }

    public void addReservation(IReservation reservation) {
        reservationDao.addReservation(reservation);
    }

    public void updateReservation(IReservation reservation) {
        reservationDao.updateReservation(reservation);
    }

    public void deleteReservation(Integer id) {
        reservationDao.deleteReservation(id);
    }
}
