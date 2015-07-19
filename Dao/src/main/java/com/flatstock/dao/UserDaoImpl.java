package com.flatstock.dao;


import com.flatstock.model.Gender;
import com.flatstock.model.IUser;
import com.flatstock.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valentin on 27.05.2015.
 */
public class UserDaoImpl implements UserDao {

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


    public List<IUser> getAllUsers() {
        Dao<List<IUser>> dao = new Dao<List<IUser>>() {
            @Override
            public List<IUser> execute(ResultSet result) throws SQLException {
                List<IUser> users = new ArrayList<IUser>();
                while (result.next()) {
                    IUser user = new User();
                    user.setId(result.getInt(ID));
                    user.setFirstName(result.getString(FIRST_NAME));
                    user.setLastName(result.getString(LAST_NAME));
                    user.setGender(Gender.fromBoolean(result.getBoolean(GENDER)));
                    user.setEmail(result.getString(EMAIL));
                    user.setLogin(result.getString(LOGIN));
                    user.setPassword(result.getString(PASSWORD));
                    user.setPhotoUrl(result.getString(PHOTO_URL));
                    users.add(user);
                }
                return users;
            }
        };
        return dao.executeQuery(SELECT_ALL_QUERY);
    }

    public IUser getUser(Integer id) {
        Dao<IUser> dao = new Dao<IUser>() {
            @Override
            public IUser execute(ResultSet result) throws SQLException {
                IUser user = new User();
                if (!result.next()) return user;
                user.setId(result.getInt(ID));
                user.setFirstName(result.getString(FIRST_NAME));
                user.setLastName(result.getString(LAST_NAME));
                user.setGender(Gender.fromBoolean(result.getBoolean(GENDER)));
                user.setEmail(result.getString(EMAIL));
                user.setLogin(result.getString(LOGIN));
                user.setPassword(result.getString(PASSWORD));
                user.setPhotoUrl(result.getString(PHOTO_URL));
                return user;
            }
        };
        return dao.executeQuery(String.format(SELECT_BY_ID, id));
    }

    public void addUser(IUser user) {
        Dao dao = new Dao() {
            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        dao.executeQuery(String.format(ADD_USER,
                user.getFirstName(),
                user.getLastName(),
                Gender.toBoolean(user.getGender()),
                user.getEmail(),
                user.getLogin(),
                user.getPassword(),
                user.getPhotoUrl()));
    }

    public void updateUser(IUser user) {
        Dao dao = new Dao() {
            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        dao.executeQuery(String.format(UPDATE_USER,
                user.getFirstName(),
                user.getLastName(),
                Gender.toBoolean(user.getGender()),
                user.getEmail(),
                user.getLogin(),
                user.getPassword(),
                user.getPhotoUrl(),
                user.getId()));
    }

    public void deleteUser(Integer id) {
        Dao dao = new Dao() {
            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        dao.executeQuery(String.format(DELETE_USER, id));
    }
}
