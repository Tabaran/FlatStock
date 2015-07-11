package com.flatstock.service;

import com.flatstock.dao.ReservationDao;
import com.flatstock.dao.ReservationDaoImpl;
import static com.flatstock.dao.ReservationDaoImpl.*;
import com.flatstock.model.IReservation;
import com.flatstock.model.Reservation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Valentin on 11.07.2015.
 */
public class ReservationServiceImpl implements ReservationService {

    ReservationDao reservationDao = new ReservationDaoImpl();

    public List<IReservation> getAllReservation() {
        ResultSet result = reservationDao.getAllReservation();
        List<IReservation> reservations = new ArrayList<IReservation>();
        IReservation reservation;
        try {
            while (result.next()){
                reservation = new Reservation();
                reservation.setId(result.getInt(ID));
                reservation.setUserId(result.getInt(USER_ID));
                reservation.setApartmentId(result.getInt(APARTMENT_ID));
                reservation.setStartTime(result.getDate(START_TIME));
                reservation.setEndTime(result.getDate(END_TIME));
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    public IReservation getReservation(Integer id) {
        ResultSet result = reservationDao.getReservation(id);
        IReservation reservation = new Reservation();
        try {
            if(!result.next())return reservation;
            reservation.setId(result.getInt(ID));
            reservation.setUserId(result.getInt(USER_ID));
            reservation.setApartmentId(result.getInt(APARTMENT_ID));
            reservation.setStartTime(result.getDate(START_TIME));
            reservation.setEndTime(result.getDate(END_TIME));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservation;
    }

    public void addReservation(IReservation reservation) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Map<String, String> params = new HashMap<String, String>();
        params.put(USER_ID, reservation.getUserId().toString());
        params.put(APARTMENT_ID, reservation.getApartmentId().toString());
        params.put(START_TIME, format.format(reservation.getStartTime()));
        params.put(END_TIME, format.format(reservation.getEndTime()));
        reservationDao.addReservation(params);
    }

    public void updateReservation(IReservation reservation) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Map<String, String> params = new HashMap<String, String>();
        params.put(USER_ID, reservation.getUserId().toString());
        params.put(APARTMENT_ID, reservation.getApartmentId().toString());
        params.put(START_TIME, format.format(reservation.getStartTime()));
        params.put(END_TIME, format.format(reservation.getEndTime()));
        params.put(ID, reservation.getId().toString());
        reservationDao.updateReservation(params);
    }

    public void deleteReservation(Integer id) {
        reservationDao.deleteReservation(id);
    }
}
