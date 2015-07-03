package com.flatstock.dao;

import com.flatstock.model.*;
import com.flatstock.utils.db.ConnectionProvider;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valentin on 31.05.2015.
 */
public class ApartmentDaoImpl implements ApartmentDao {
    static Logger LOG = Logger.getLogger(ApartmentDaoImpl.class.getName());

    private ConnectionProvider provider = new ConnectionProvider();
    private static final String TABLE_NAME = "apartment";
    private static final String APARTMENT_ID = "id";
    private static final String ADDRESS = "address";
    private static final String ROOM_NUMBER = "room_number";
    private static final String FLOOR = "floor";
    private static final String PRICE = "price";
    private static final String RATING = "rating";
    private static final String PHOTO_URL = "photo_url";
    private static final String OWNER_ID = "user_id";
    private static final String TYPE = "type";
    private static final String DESCRIPTION = "description";

    private static final String SELECT_ALL_QUERY = "SELECT * FROM "+TABLE_NAME;
    private static final String SELECT_BY_ID = "SELECT * FROM "+TABLE_NAME+" WHERE "+APARTMENT_ID+ "=%s";
    private static final String ADD_APARTMENT = "INSERT INTO "+TABLE_NAME+" ("+
            ADDRESS+", "+ ROOM_NUMBER+", "+ FLOOR+", "+ PRICE+", "+
            RATING +", "+ PHOTO_URL+", "+ OWNER_ID + ", " + TYPE + ", " + DESCRIPTION + ") " +
            "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')";
    private static final String UPDATE_APARTMENT = "UPDATE "+TABLE_NAME+" SET "
            + ADDRESS+"='%s', "+ ROOM_NUMBER+"='%s', "+ FLOOR +"='%s', "
            + PRICE+"='%s', "+ RATING +"='%s', "+ PHOTO_URL +"='%s', "
            + OWNER_ID+"='%s', "+TYPE+"='%s', "+DESCRIPTION+"='%s' WHERE id=%s";
    private static final String DELETE_APARTMENT = "DELETE FROM "+TABLE_NAME+" WHERE " +APARTMENT_ID +"=%s";
    private static final String SELECT_BY_OWNER_ID = "SELECT * FROM "+TABLE_NAME+" WHERE "+OWNER_ID+ "=%s";


    public List<IApartment> getAllApartments() {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = provider.getConnection();
            statement = connection.createStatement();
            LOG.info("Trying to execute query: " + SELECT_ALL_QUERY);
            statement.execute(SELECT_ALL_QUERY);
            ResultSet result = statement.getResultSet();
            List<IApartment> apartments = new ArrayList<IApartment>();
            while (result.next()){
                IApartment apartment = new Apartment();
                apartment.setId(result.getInt(APARTMENT_ID));
                apartment.setAddress(result.getString(ADDRESS));
                apartment.setRoomNumber(result.getInt(ROOM_NUMBER));
                apartment.setFloor(result.getInt(FLOOR));
                apartment.setPrice(result.getInt(PRICE));
                apartment.setRating(result.getInt(RATING));
                apartment.setOwnerId(result.getInt(OWNER_ID));
                apartment.setType(ApartmentsType.fromString(result.getString(TYPE)));
                apartment.setDescription(result.getString(DESCRIPTION));
                apartment.setPhotoUrl(result.getString(PHOTO_URL));
                apartments.add(apartment);
            }
            return apartments;
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

    public List<IApartment> getApartmentsByOwnerId(Integer ownerId) {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = provider.getConnection();
            statement = connection.createStatement();
            String query = String.format(SELECT_BY_OWNER_ID, ownerId);
            LOG.info("Trying to execute query: " + query);
            statement.execute(query);
            ResultSet result = statement.getResultSet();
            List<IApartment> apartments = new ArrayList<IApartment>();
            while (result.next()){
                IApartment apartment = new Apartment();
                apartment.setId(result.getInt(APARTMENT_ID));
                apartment.setAddress(result.getString(ADDRESS));
                apartment.setRoomNumber(result.getInt(ROOM_NUMBER));
                apartment.setFloor(result.getInt(FLOOR));
                apartment.setPrice(result.getInt(PRICE));
                apartment.setRating(result.getInt(RATING));
                apartment.setOwnerId(result.getInt(OWNER_ID));
                apartment.setType(ApartmentsType.fromString(result.getString(TYPE)));
                apartment.setDescription(result.getString(DESCRIPTION));
                apartment.setPhotoUrl(result.getString(PHOTO_URL));
                apartments.add(apartment);
            }
            return apartments;
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

    public IApartment getApartment(Integer id) {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = provider.getConnection();
            statement = connection.createStatement();
            String query = String.format(SELECT_BY_ID, id);
            LOG.info("Trying to execute query: " + query);
            statement.execute(query);
            IApartment apartment = new Apartment();
            ResultSet result = statement.getResultSet();
            if(!result.next())return null;
            apartment.setId(result.getInt(APARTMENT_ID));
            apartment.setAddress(result.getString(ADDRESS));
            apartment.setRoomNumber(result.getInt(ROOM_NUMBER));
            apartment.setFloor(result.getInt(FLOOR));
            apartment.setPrice(result.getInt(PRICE));
            apartment.setRating(result.getInt(RATING));
            apartment.setOwnerId(result.getInt(OWNER_ID));
            apartment.setType(ApartmentsType.fromString(result.getString(TYPE)));
            apartment.setDescription(result.getString(DESCRIPTION));
            apartment.setPhotoUrl(result.getString(PHOTO_URL));
            return apartment;
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

    public void addApartment(IApartment apartment) {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = provider.getConnection();
            statement = connection.createStatement();
            String query = String.format(ADD_APARTMENT,
                    apartment.getAddress(),
                    apartment.getRoomNumber(),
                    apartment.getFloor(),
                    apartment.getPrice(),
                    apartment.getRating(),
                    apartment.getPhotoUrl(),
                    apartment.getOwnerId(),
                    apartment.getType(),
                    apartment.getDescription());
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

    public void updateApartment(IApartment apartment) {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = provider.getConnection();
            statement = connection.createStatement();
            String query = String.format(UPDATE_APARTMENT,
                    apartment.getAddress(),
                    apartment.getRoomNumber(),
                    apartment.getFloor(),
                    apartment.getPrice(),
                    apartment.getRating(),
                    apartment.getPhotoUrl(),
                    apartment.getOwnerId(),
                    apartment.getType(),
                    apartment.getDescription(),
                    apartment.getId());
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

    public void deleteApartment(Integer id) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = provider.getConnection();
            statement = connection.createStatement();
            String query = String.format(DELETE_APARTMENT, id);
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
}
