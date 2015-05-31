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
public class ApartmentDaoImpl implements ApartmentDao {
    private static final String TABLE_NAME = "Apartments";
    private static final String APARTMENT_ID = "apartment_id";
    private static final String ADDRESS = "address";
    private static final String ROOM_NUMBER = "room_number";
    private static final String FLOOR = "floor";
    private static final String PRICE = "price";
    private static final String RATING = "rating";
    private static final String PHOTO_URL = "photo_url";
    private static final String OWNER_ID = "owner_id";
    private static final String TYPE = "type";
    private static final String DESCRIPTION = "description";

    private static final String SELECT_ALL_QUERY = "SELECT * FROM "+TABLE_NAME;
    private static final String SELECT_BY_ID = "SELECT * FROM "+TABLE_NAME+" WHERE "+APARTMENT_ID+ "=%s";
    private static final String ADD_APARTMENT = "INSERT INTO "+TABLE_NAME+" COLUMNS ("+
            APARTMENT_ID+", "+ ADDRESS+", "+ ROOM_NUMBER+", "+ FLOOR+", "+ PRICE+", "+
            RATING +", "+ PHOTO_URL+", "+ OWNER_ID+", "+TYPE+", "+DESCRIPTION+") " +
            "VALUES (%s1, %s2, %s3, %s4, %s5, %s6, %s7, %s8, %s9, %s10 )";
    private static final String UPDATE_APARTMENT = "UPDATE "+TABLE_NAME+" SET "
            +APARTMENT_ID +"=%s1,"+ ADDRESS+"=%s2,"+ ROOM_NUMBER+"=%s3,"+ FLOOR +"=%s4,"
            + PRICE+"=%s5,"+ RATING +"=%s6,"+ PHOTO_URL +"=%s7,"+ OWNER_ID+"=%s8"+TYPE+"=%s9"+DESCRIPTION+"=%s10";
    private static final String DELETE_APARTMENT = "DELETE FROM "+TABLE_NAME+" WHERE " +APARTMENT_ID +"=%s1";
    private static final String SELECT_BY_OWNER_ID = "SELECT * FROM "+TABLE_NAME+" WHERE "+OWNER_ID+ "=%s";
    public List<IApartment> getAllApartments() {
        try {
            Statement statement = ConnectionProvider.getConnection().createStatement();
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
            e.printStackTrace();
        }
        return null;
    }

    public List<IApartment> getApartmentsByOwnerId(Integer ownerId) {
        try {
            Statement statement = ConnectionProvider.getConnection().createStatement();
            statement.execute(String.format(SELECT_BY_OWNER_ID, ownerId));
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
            e.printStackTrace();
        }
        return null;
    }

    public IApartment getApartment(Integer id) {
        try {
            Statement statement = ConnectionProvider.getConnection().createStatement();
            statement.execute(String.format(SELECT_BY_ID, id));
            IApartment apartment = new Apartment();
            ResultSet result = statement.getResultSet();
            if(!result.first())return null;
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
            e.printStackTrace();
        }
        return null;
    }

    public void addApartment(IApartment apartment) {
        try {
            Statement statement = ConnectionProvider.getConnection().createStatement();
            String query = String.format(ADD_APARTMENT,
                    apartment.getId(),
                    apartment.getAddress(),
                    apartment.getRoomNumber(),
                    apartment.getFloor(),
                    apartment.getPrice(),
                    apartment.getRating(),
                    apartment.getPhotoUrl(),
                    apartment.getOwnerId(),
                    apartment.getType(),
                    apartment.getDescription());
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateApartment(IApartment apartment) {
        try {
            Statement statement = ConnectionProvider.getConnection().createStatement();
            String query = String.format(UPDATE_APARTMENT,
                    apartment.getId(),
                    apartment.getAddress(),
                    apartment.getRoomNumber(),
                    apartment.getFloor(),
                    apartment.getPrice(),
                    apartment.getRating(),
                    apartment.getPhotoUrl(),
                    apartment.getOwnerId(),
                    apartment.getType(),
                    apartment.getDescription());
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteApartment(Integer id) {
        try {
            Statement statement = ConnectionProvider.getConnection().createStatement();
            statement.execute(String.format(DELETE_APARTMENT, id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
