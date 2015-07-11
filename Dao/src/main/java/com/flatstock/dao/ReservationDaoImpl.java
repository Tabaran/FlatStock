package com.flatstock.dao;


import org.apache.log4j.Logger;


import java.sql.ResultSet;
import java.util.Map;


/**
 * Created by Valentin on 31.05.2015.
 */
public class ReservationDaoImpl extends Dao implements ReservationDao{
    static Logger LOG = Logger.getLogger(ReservationDaoImpl.class.getName());

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

    public ResultSet getAllReservation() {
        return executeQuery(SELECT_ALL_QUERY);
    }


    public ResultSet getReservation(Integer id) {
        return executeQuery(String.format(SELECT_BY_ID, id));
    }

    public void addReservation(Map<String, String> params) {
        executeQuery(String.format(ADD_RESERVATION,
                params.get(USER_ID),
                params.get(APARTMENT_ID),
                params.get(START_TIME),
                params.get(END_TIME)));
    }

    public void updateReservation(Map<String, String> params) {
        executeQuery(String.format(UPDATE_RESERVATION,
                params.get(USER_ID),
                params.get(APARTMENT_ID),
                params.get(START_TIME),
                params.get(END_TIME),
                params.get(ID)));
    }

    public void deleteReservation(Integer id) {
        executeQuery(String.format(DELETE_RESERVATION, id));
    }
}
