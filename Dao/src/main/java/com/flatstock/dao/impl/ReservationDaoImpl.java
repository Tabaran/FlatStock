package com.flatstock.dao.impl;
import com.flatstock.dao.ReservationDao;
import com.flatstock.model.IReservation;
import com.flatstock.model.impl.Reservation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private static final String SELECT_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + "=%s";
    private static final String ADD_RESERVATION = "INSERT INTO " + TABLE_NAME +
            " (" + USER_ID + ", " + APARTMENT_ID + ", " +
            START_TIME + ", " + END_TIME + ") VALUES ('%s', '%s', '%s', '%s')";
    private static final String UPDATE_RESERVATION = "UPDATE " + TABLE_NAME +
            " SET " + USER_ID + "='%s'," + APARTMENT_ID + "='%s'," +
            START_TIME + "='%s'," + END_TIME + "='%s' WHERE id=%s";
    private static final String DELETE_RESERVATION = "DELETE FROM " + TABLE_NAME + " WHERE " + ID + "=%s";

    public List<IReservation> getAllReservation() {
        Dao<List<IReservation>> dao = new Dao<List<IReservation>>() {
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


    public IReservation getReservation(Integer id) {
        Dao<IReservation> dao = new Dao<IReservation>() {
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
        return dao.executeQuery(String.format(SELECT_BY_ID, id));
    }

    public void addReservation(IReservation reservation) {
        Dao dao = new Dao() {
            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        dao.executeQuery(String.format(ADD_RESERVATION,
                reservation.getUserId(),
                reservation.getApartmentId(),
                format.format(reservation.getStartTime()),
                format.format(reservation.getEndTime())));
    }

    public void updateReservation(IReservation reservation) {
        Dao dao = new Dao() {
            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        dao.executeQuery(String.format(UPDATE_RESERVATION,
                reservation.getUserId(),
                reservation.getApartmentId(),
                format.format(reservation.getStartTime()),
                format.format(reservation.getEndTime()),
                reservation.getId()));
    }

    public void deleteReservation(Integer id) {
        Dao dao = new Dao() {
            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        dao.executeQuery(String.format(DELETE_RESERVATION, id));
    }
}
