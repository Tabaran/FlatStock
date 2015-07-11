package com.flatstock.dao;


import java.sql.ResultSet;
import java.util.Map;

/**
 * Created by Valentin on 31.05.2015.
 */
public class ApartmentDaoImpl extends Dao implements ApartmentDao {

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

    public ResultSet getAllApartments() {
        return executeQuery(SELECT_ALL_QUERY);
    }

    public ResultSet getApartmentsByOwnerId(Integer ownerId) {
       return executeQuery(String.format(SELECT_BY_OWNER_ID, ownerId));
    }

    public ResultSet getApartment(Integer id) {
        return executeQuery(String.format(SELECT_BY_ID, id));
    }

    public void addApartment(Map<String, String> params) {
        executeQuery(String.format(ADD_APARTMENT,
                params.get(ADDRESS),
                params.get(ROOM_NUMBER),
                params.get(FLOOR),
                params.get(PRICE),
                params.get(RATING),
                params.get(PHOTO_URL),
                params.get(OWNER_ID),
                params.get(TYPE),
                params.get(DESCRIPTION)));

    }

    public void updateApartment(Map<String, String> params) {
        executeQuery(String.format(ADD_APARTMENT,
                params.get(ADDRESS),
                params.get(ROOM_NUMBER),
                params.get(FLOOR),
                params.get(PRICE),
                params.get(RATING),
                params.get(PHOTO_URL),
                params.get(OWNER_ID),
                params.get(TYPE),
                params.get(DESCRIPTION),
                params.get(ID)));
    }

    public void deleteApartment(Integer id) {
        executeQuery(String.format(DELETE_APARTMENT, id));
    }
}
