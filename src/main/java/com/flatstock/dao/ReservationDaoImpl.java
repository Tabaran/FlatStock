package com.flatstock.dao;

import com.flatstock.model.*;
import com.flatstock.utils.jdbc.ConnectionProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valentin on 31.05.2015.
 */
public class ReservationDaoImpl implements ReservationDao{
    private static final String TABLE_NAME = "Reservation";
    private static final String RES_ID = "res_id";
    private static final String USER_ID = "user_id";
    private static final String APARTMENT_ID = "apartment_id";
    private static final String START_TIME = "start_time ";
    private static final String END_TIME = "end_time ";

    private static final String SELECT_ALL_QUERY = "SELECT * FROM " + TABLE_NAME;
    private static final String SELECT_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + RES_ID + "=%s";
    private static final String ADD_RESERVATION = "INSERT INTO " + TABLE_NAME +
            " COLUMNS (" + RES_ID + ", " + USER_ID + ", " + APARTMENT_ID + ", " +
            START_TIME + ", " + END_TIME + ") VALUES (%s1, %s2, %s3, %s4, %s5)";
    private static final String UPDATE_RESERVATION = "UPDATE " + TABLE_NAME +
            " SET " + RES_ID + "=%s1," + USER_ID + "=%s2," + APARTMENT_ID + "=%s3," +
            START_TIME + "=%s4," + END_TIME + "=%s5,";
    private static final String DELETE_RESERVATION = "DELETE FROM " + TABLE_NAME + " WHERE " + RES_ID + "=%s1";

    public List<IReservation> getAllReservation() {
        try {
            Statement statement = ConnectionProvider.getConnection().createStatement();
            statement.execute(SELECT_ALL_QUERY);
            ResultSet result = statement.getResultSet();
            List<IReservation> reservations = new ArrayList<IReservation>();
            IReservation reservation;
            while (result.next()){
                reservation = new Reservation();
                reservation.setId(result.getInt(RES_ID));
                reservation.setUserId(result.getInt(USER_ID));
                reservation.setApartmentId(result.getInt(APARTMENT_ID));
                reservation.setStartTime(result.getDate(START_TIME));
                reservation.setEndTime(result.getDate(END_TIME));
                reservations.add(reservation);
            }
            return reservations;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public IReservation getReservation(Integer id) {
        try {
            Statement statement = ConnectionProvider.getConnection().createStatement();
            statement.execute(String.format(SELECT_BY_ID, id));
            ResultSet result = statement.getResultSet();
            if(!result.first())return null;
            IReservation reservation = new Reservation();
            reservation.setId(result.getInt(RES_ID));
            reservation.setUserId(result.getInt(USER_ID));
            reservation.setApartmentId(result.getInt(APARTMENT_ID));
            reservation.setStartTime(result.getDate(START_TIME));
            reservation.setEndTime(result.getDate(END_TIME));
            return reservation;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addReservation(IReservation reservation) {
        try {
            Statement statement = ConnectionProvider.getConnection().createStatement();
            String query = String.format(ADD_RESERVATION,
                   reservation.getId(),
                   reservation.getUserId(),
                   reservation.getApartmentId(),
                   reservation.getStartTime(),
                   reservation.getEndTime(),
                   reservation.getUserId());
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateReservation(IReservation reservation) {
        try {
            Statement statement = ConnectionProvider.getConnection().createStatement();
            String query = String.format(UPDATE_RESERVATION,
                    reservation.getId(),
                    reservation.getUserId(),
                    reservation.getApartmentId(),
                    reservation.getStartTime(),
                    reservation.getUserId());
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteReservation(Integer id) {
        try {
            Statement statement = ConnectionProvider.getConnection().createStatement();
            statement.execute(String.format(DELETE_RESERVATION, id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
