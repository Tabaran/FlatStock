package com.flatstock.dao.impl;


import com.flatstock.dao.ApartmentDao;
import com.flatstock.model.impl.Apartment;
import com.flatstock.model.ApartmentsType;
import com.flatstock.model.IApartment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Valentin on 31.05.2015.
 */
public class ApartmentDaoImpl implements ApartmentDao {

    public static final String TABLE_NAME = "apartment";
    public static final String ID = "id";
    public static final String ADDRESS = "address";
    public static final String ROOM_NUMBER = "room_number";
    public static final String FLOOR = "floor";
    public static final String PRICE = "price";
    public static final String RATING = "rating";
    public static final String PHOTO_URL = "photo_url";
    public static final String OWNER_ID = "user_id";
    public static final String TYPE = "type";
    public static final String DESCRIPTION = "description";

    private static final String SELECT_ALL_QUERY = "SELECT * FROM "+TABLE_NAME;
    private static final String SELECT_BY_ID = "SELECT * FROM "+TABLE_NAME+" WHERE "+ ID + "=?";
    private static final String ADD_APARTMENT = "INSERT INTO "+TABLE_NAME+" ("+
            ADDRESS+", "+ ROOM_NUMBER+", "+ FLOOR+", "+ PRICE+", "+
            RATING +", "+ PHOTO_URL+", "+ OWNER_ID + ", " + TYPE + ", " + DESCRIPTION + ") " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_APARTMENT = "UPDATE "+TABLE_NAME+" SET "
            + ADDRESS+"=?, "+ ROOM_NUMBER+"=?, "+ FLOOR +"=?, "
            + PRICE+"=?, "+ RATING +"=?, "+ PHOTO_URL +"=?, "
            + OWNER_ID+"=?, "+TYPE+"=?, "+DESCRIPTION+"=? WHERE id=?";
    private static final String DELETE_APARTMENT = "DELETE FROM "+TABLE_NAME+" WHERE " + ID +"=?";
    private static final String SELECT_BY_OWNER_ID = "SELECT * FROM "+TABLE_NAME+" WHERE "+OWNER_ID+ "=?";

    public List<IApartment> getAllApartments() {
        Dao<List<IApartment>> dao = new Dao<List<IApartment>>() {
            @Override
            public void prepare(PreparedStatement statement) {

            }

            @Override
            public List<IApartment> execute(ResultSet result) throws SQLException {
                List<IApartment> apartments = new ArrayList<IApartment>();
                while (result.next()) {
                    IApartment apartment = new Apartment();
                    apartment.setId(result.getInt(ID));
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
            }
        };
        return dao.executeQuery(SELECT_ALL_QUERY);
    }

    public List<IApartment> getApartmentsByOwnerId(final Integer ownerId) {
        Dao<List<IApartment>> dao = new Dao<List<IApartment>>() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setInt(1, ownerId);
            }

            @Override
            public List<IApartment> execute(ResultSet result) throws SQLException {
                List<IApartment> apartments = new ArrayList<IApartment>();
                    while (result.next()){
                        IApartment apartment = new Apartment();
                        apartment.setId(result.getInt(ID));
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
            }
        };
        return dao.executeQuery(SELECT_BY_OWNER_ID);
    }

    public IApartment getApartment(final Integer id) {
        Dao<IApartment> dao = new Dao<IApartment>() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setInt(1, id);
            }

            @Override
            public IApartment execute(ResultSet result) throws SQLException {
                IApartment apartment = new Apartment();
                if(!result.next())return apartment;
                apartment.setId(result.getInt(ID));
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
            }
        };
        return dao.executeQuery(SELECT_BY_ID);
    }

    public void addApartment(final IApartment apartment) {
        Dao dao = new Dao() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setString(1, apartment.getAddress());
                statement.setInt(2, apartment.getRoomNumber());
                statement.setInt(3, apartment.getFloor());
                statement.setInt(4, apartment.getPrice());
                statement.setInt(5, apartment.getRating());
                statement.setString(6, apartment.getPhotoUrl());
                statement.setInt(7, apartment.getOwnerId());
                statement.setString(8, ApartmentsType.FLAT.toString());
                statement.setString(9, apartment.getDescription());
            }

            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        dao.executeQuery(ADD_APARTMENT);
    }

    public void updateApartment(final IApartment apartment) {
        Dao dao = new Dao() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setString(1, apartment.getAddress());
                statement.setInt(2, apartment.getRoomNumber());
                statement.setInt(3, apartment.getFloor());
                statement.setInt(4, apartment.getPrice());
                statement.setInt(5, apartment.getRating());
                statement.setString(6, apartment.getPhotoUrl());
                statement.setInt(7, apartment.getOwnerId());
                statement.setString(8, ApartmentsType.FLAT.toString());
                statement.setString(9, apartment.getDescription());
                statement.setInt(10, apartment.getId());
            }

            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        dao.executeQuery(UPDATE_APARTMENT);
    }

    public void deleteApartment(final Integer id) {
        Dao dao = new Dao() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setInt(1, id);
            }

            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };

        dao.executeQuery(DELETE_APARTMENT);
    }
}
