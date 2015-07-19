package com.flatstock.dao;


import com.flatstock.model.Apartment;
import com.flatstock.model.ApartmentsType;
import com.flatstock.model.IApartment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private static final String SELECT_BY_ID = "SELECT * FROM "+TABLE_NAME+" WHERE "+ ID + "=%s";
    private static final String ADD_APARTMENT = "INSERT INTO "+TABLE_NAME+" ("+
            ADDRESS+", "+ ROOM_NUMBER+", "+ FLOOR+", "+ PRICE+", "+
            RATING +", "+ PHOTO_URL+", "+ OWNER_ID + ", " + TYPE + ", " + DESCRIPTION + ") " +
            "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')";
    private static final String UPDATE_APARTMENT = "UPDATE "+TABLE_NAME+" SET "
            + ADDRESS+"='%s', "+ ROOM_NUMBER+"='%s', "+ FLOOR +"='%s', "
            + PRICE+"='%s', "+ RATING +"='%s', "+ PHOTO_URL +"='%s', "
            + OWNER_ID+"='%s', "+TYPE+"='%s', "+DESCRIPTION+"='%s' WHERE id=%s";
    private static final String DELETE_APARTMENT = "DELETE FROM "+TABLE_NAME+" WHERE " + ID +"=%s";
    private static final String SELECT_BY_OWNER_ID = "SELECT * FROM "+TABLE_NAME+" WHERE "+OWNER_ID+ "=%s";

    public List<IApartment> getAllApartments() {
        Dao<List<IApartment>> dao = new Dao<List<IApartment>>() {
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

    public List<IApartment> getApartmentsByOwnerId(Integer ownerId) {
        Dao<List<IApartment>> dao = new Dao<List<IApartment>>() {
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
       return dao.executeQuery(String.format(SELECT_BY_OWNER_ID, ownerId));
    }

    public IApartment getApartment(Integer id) {
        Dao<IApartment> dao = new Dao<IApartment>() {
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
        return dao.executeQuery(String.format(SELECT_BY_ID, id));
    }

    public void addApartment(IApartment apartment) {
        Dao dao = new Dao() {
            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        dao.executeQuery(String.format(ADD_APARTMENT,
                apartment.getAddress(),
                apartment.getRoomNumber(),
                apartment.getFloor(),
                apartment.getPrice(),
                apartment.getRating(),
                apartment.getPhotoUrl(),
                apartment.getOwnerId(),
                apartment.getType().toString(),
                apartment.getDescription()));
    }

    public void updateApartment(IApartment apartment) {
        Dao dao = new Dao() {
            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        dao.executeQuery(String.format(UPDATE_APARTMENT,
                apartment.getAddress(),
                apartment.getRoomNumber(),
                apartment.getFloor(),
                apartment.getPrice(),
                apartment.getRating(),
                apartment.getPhotoUrl(),
                apartment.getOwnerId(),
                apartment.getType().toString(),
                apartment.getDescription(),
                apartment.getId()));
    }

    public void deleteApartment(Integer id) {
        Dao dao = new Dao() {
            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        dao.executeQuery(String.format(DELETE_APARTMENT, id));
    }
}
