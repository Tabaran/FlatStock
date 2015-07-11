package com.flatstock.dao;


import java.sql.ResultSet;
import java.util.Map;


/**
 * Created by Valentin on 27.05.2015.
 */
public class UserDaoImpl extends Dao implements UserDao {

    private static final String TABLE_NAME = "Users";
    public static final String ID = "id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String GENDER = "gender";
    public static final String EMAIL = "email";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String PHOTO_URL = "photo_url";

    private static final String SELECT_ALL_QUERY = "SELECT * FROM "+TABLE_NAME;
    private static final String SELECT_BY_ID = "SELECT * FROM "+TABLE_NAME+" WHERE " +ID+ "=%s";
    private static final String ADD_USER = "INSERT INTO "+TABLE_NAME+" (" + FIRST_NAME + ", " + LAST_NAME + ", " + GENDER+", "+ EMAIL+", "+ LOGIN +", "+ PASSWORD+", "+ PHOTO_URL+") VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s')";
    private static final String UPDATE_USER = "UPDATE "+TABLE_NAME+" SET " + FIRST_NAME+"='%s', "+ LAST_NAME+"='%s', "+ GENDER +"='%s', "+ EMAIL+"='%s', "+ LOGIN +"='%s', " + PASSWORD + "='%s', " + PHOTO_URL + "='%s'" + " WHERE id=" + "'%s'";
    private static final String DELETE_USER = "DELETE FROM "+TABLE_NAME+" WHERE " +ID +"=%s";


    public ResultSet getAllUsers() {
        return executeQuery(SELECT_ALL_QUERY);
    }

    public ResultSet getUser(Integer id) {
        return executeQuery(String.format(SELECT_BY_ID, id));
    }

    public void addUser(Map<String, String> params) {
        executeQuery(String.format(ADD_USER,
                params.get(FIRST_NAME),
                params.get(LAST_NAME),
                params.get(GENDER),
                params.get(EMAIL),
                params.get(LOGIN),
                params.get(PASSWORD),
                params.get(PHOTO_URL)));
    }

    public void updateUser(Map<String, String> params) {
        executeQuery(String.format(UPDATE_USER,
                params.get(FIRST_NAME),
                params.get(LAST_NAME),
                params.get(GENDER),
                params.get(EMAIL),
                params.get(LOGIN),
                params.get(PASSWORD),
                params.get(PHOTO_URL),
                params.get(ID)));
    }

    public void deleteUser(Integer id) {
        executeQuery(String.format(DELETE_USER, id));
    }
}
