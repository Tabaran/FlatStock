package com.flatstock.dao.impl;
import com.flatstock.dao.ReservationDao;
import com.flatstock.model.IReservation;
import com.flatstock.model.impl.Reservation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Valentin on 31.05.2015.
 */
public class ReservationDaoImpl implements ReservationDao {


    private static final String TABLE_NAME = "Reservation";
    public static final String ID = "id";
    public static final String USER_ID = "user_id";
    public static final String APARTMENT_ID = "apartment_id";
    public static final String START_TIME = "start_time";
    public static final String END_TIME = "end_time";

    private static final String SELECT_ALL_QUERY = "SELECT * FROM " + TABLE_NAME;
    private static final String SELECT_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + "=?";
    private static final String ADD_RESERVATION = "INSERT INTO " + TABLE_NAME +
            " (" + USER_ID + ", " + APARTMENT_ID + ", " +
            START_TIME + ", " + END_TIME + ") VALUES (?, ?, ?, ?)";
    private static final String UPDATE_RESERVATION = "UPDATE " + TABLE_NAME +
            " SET " + USER_ID + "=?," + APARTMENT_ID + "=?," +
            START_TIME + "=?," + END_TIME + "=? WHERE id=?";
    private static final String DELETE_RESERVATION = "DELETE FROM " + TABLE_NAME + " WHERE " + ID + "=?";

    public List<IReservation> getAllReservation() {
        Dao<List<IReservation>> dao = new Dao<List<IReservation>>() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {

            }

            @Override
            public List<IReservation> execute(ResultSet result) throws SQLException {
                List<IReservation> reservations = new ArrayList<IReservation>();
                IReservation reservation;
                    while (result.next()){
                        reservation = new Reservation();
                        reservation.setId(result.getInt(ID));
                        reservation.setUserId(result.getInt(USER_ID));
                        reservation.setApartmentId(result.getInt(APARTMENT_ID));
                        reservation.setStartTime(result.getDate(START_TIME));
                        reservation.setEndTime(result.getDate(END_TIME));
                        reservations.add(reservation);
                    }

                return reservations;
            }
        };
        return dao.executeQuery(SELECT_ALL_QUERY);
    }


    public IReservation getReservation(final Integer id) {
        Dao<IReservation> dao = new Dao<IReservation>() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setInt(1, id);
            }

            @Override
            public IReservation execute(ResultSet result) throws SQLException {
                IReservation reservation = new Reservation();
                if (!result.next()) return reservation;
                reservation.setId(result.getInt(ID));
                reservation.setUserId(result.getInt(USER_ID));
                reservation.setApartmentId(result.getInt(APARTMENT_ID));
                reservation.setStartTime(result.getDate(START_TIME));
                reservation.setEndTime(result.getDate(END_TIME));
                return reservation;
            }
        };
        return dao.executeQuery(SELECT_BY_ID);
    }

    public void addReservation(final IReservation reservation) {
        Dao dao = new Dao() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setInt(1, reservation.getUserId());
                statement.setInt(2, reservation.getApartmentId());
                statement.setDate(3, new java.sql.Date(reservation.getStartTime().getTime()));
                statement.setDate(4, new java.sql.Date(reservation.getEndTime().getTime()));
            }

            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        dao.executeQuery(ADD_RESERVATION);
    }

    public void updateReservation(final IReservation reservation) {
        Dao dao = new Dao() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setInt(1, reservation.getUserId());
                statement.setInt(2, reservation.getApartmentId());
                statement.setDate(3, new java.sql.Date(reservation.getStartTime().getTime()));
                statement.setDate(4, new java.sql.Date(reservation.getEndTime().getTime()));
                statement.setInt(5, reservation.getId());
            }

            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        dao.executeQuery(UPDATE_RESERVATION);
    }

    public void deleteReservation(final Integer id) {
        final Dao dao = new Dao() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setInt(1, id);
            }

            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        dao.executeQuery(DELETE_RESERVATION);
    }
}
