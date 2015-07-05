package com.flatstock.dao;

import com.flatstock.model.*;
import com.flatstock.utils.db.ConnectionProvider;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Valentin on 31.05.2015.
 */
public class ReservationDaoImpl implements ReservationDao{
    static Logger LOG = Logger.getLogger(ReservationDaoImpl.class.getName());

    private ConnectionProvider provider = new ConnectionProvider();
    private static final String TABLE_NAME = "Reservation";
    private static final String RES_ID = "id";
    private static final String USER_ID = "user_id";
    private static final String APARTMENT_ID = "apartment_id";
    private static final String START_TIME = "start_time";
    private static final String END_TIME = "end_time";

    private static final String SELECT_ALL_QUERY = "SELECT * FROM " + TABLE_NAME;
    private static final String SELECT_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + RES_ID + "=%s";
    private static final String ADD_RESERVATION = "INSERT INTO " + TABLE_NAME +
            " (" + USER_ID + ", " + APARTMENT_ID + ", " +
            START_TIME + ", " + END_TIME + ") VALUES ('%s', '%s', '%s', '%s')";
    private static final String UPDATE_RESERVATION = "UPDATE " + TABLE_NAME +
            " SET " + USER_ID + "='%s'," + APARTMENT_ID + "='%s'," +
            START_TIME + "='%s'," + END_TIME + "='%s' WHERE id=%s";
    private static final String DELETE_RESERVATION = "DELETE FROM " + TABLE_NAME + " WHERE " + RES_ID + "=%s";

    public List<IReservation> getAllReservation() {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = provider.getConnection();
            statement = connection.createStatement();
            LOG.info("Trying to execute query: " + SELECT_ALL_QUERY);
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
            LOG.error(e);
        }
        finally {
            try {
                if (statement != null)  statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                LOG.error(e);
            }
        }
        return null;
    }


    public IReservation getReservation(Integer id) {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = provider.getConnection();
            statement = connection.createStatement();
            String query = String.format(SELECT_BY_ID, id);
            LOG.info("Trying to execute query: " + query);
            statement.execute(query);
            ResultSet result = statement.getResultSet();
            if(!result.next())return null;
            IReservation reservation = new Reservation();
            reservation.setId(result.getInt(RES_ID));
            reservation.setUserId(result.getInt(USER_ID));
            reservation.setApartmentId(result.getInt(APARTMENT_ID));
            reservation.setStartTime(result.getDate(START_TIME));
            reservation.setEndTime(result.getDate(END_TIME));
            return reservation;
        } catch (SQLException e) {
            LOG.error(e);
        }
        finally {
            try {
                if (statement != null)  statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                LOG.error(e);
            }
        }
        return null;
    }

    public void addReservation(IReservation reservation) {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = provider.getConnection();
            statement = connection.createStatement();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String query = String.format(ADD_RESERVATION,
                   reservation.getUserId(),
                   reservation.getApartmentId(),
                   format.format(reservation.getStartTime()),
                    format.format(reservation.getEndTime()),
                   reservation.getUserId());
            LOG.info("Trying to execute query: " + query);
            statement.execute(query);
        } catch (SQLException e) {
            LOG.error(e);
        }
        finally {
            try {
                if (statement != null)  statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                LOG.error(e);
            }
        }
    }

    public void updateReservation(IReservation reservation) {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = provider.getConnection();
            statement = connection.createStatement();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String query = String.format(UPDATE_RESERVATION,
                    reservation.getUserId(),
                    reservation.getApartmentId(),
                    format.format(reservation.getStartTime()),
                    format.format(reservation.getEndTime()),
                    reservation.getId());
            LOG.info("Trying to execute query: " + query);
            statement.execute(query);
        } catch (SQLException e) {
            LOG.error(e);
        }
        finally {
            try {
                if (statement != null)  statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                LOG.error(e);
            }
        }
    }

    public void deleteReservation(Integer id) {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = provider.getConnection();
            statement = connection.createStatement();
            statement.execute(String.format(DELETE_RESERVATION, id));
        } catch (SQLException e) {
            LOG.error(e);
        }
        finally {
            try {
                if (statement != null)  statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                LOG.error(e);
            }
        }
    }
}
