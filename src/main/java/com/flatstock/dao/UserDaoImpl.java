package com.flatstock.dao;

import com.flatstock.model.Gender;
import com.flatstock.model.User;
import com.flatstock.model.IUser;
import com.flatstock.utils.db.ConnectionProvider;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Valentin on 27.05.2015.
 */
public class UserDaoImpl implements UserDao {
    static Logger LOG = Logger.getLogger(UserDaoImpl.class.getName());

    private ConnectionProvider provider = new ConnectionProvider();
    private static final String TABLE_NAME = "Users";
    private static final String ID = "id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String GENDER = "gender";
    private static final String EMAIL = "email";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String PHOTO_URL = "photo_url";

    private static final String SELECT_ALL_QUERY = "SELECT * FROM "+TABLE_NAME;
    private static final String SELECT_BY_ID = "SELECT * FROM "+TABLE_NAME+" WHERE " +ID+ "=%s";
    private static final String ADD_USER = "INSERT INTO "+TABLE_NAME+" (" + FIRST_NAME + ", " + LAST_NAME + ", " + GENDER+", "+ EMAIL+", "+ LOGIN +", "+ PASSWORD+", "+ PHOTO_URL+") VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s')";
    private static final String UPDATE_USER = "UPDATE "+TABLE_NAME+" SET " + FIRST_NAME+"='%s', "+ LAST_NAME+"='%s', "+ GENDER +"='%s', "+ EMAIL+"='%s', "+ LOGIN +"='%s', " + PASSWORD + "='%s', " + PHOTO_URL + "='%s'" + " WHERE id=" + "'%s'";
    private static final String DELETE_USER = "DELETE FROM "+TABLE_NAME+" WHERE " +ID +"=%s";

    public List<IUser> getAllUsers() {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = provider.getConnection();
            statement = connection.createStatement();
            LOG.info("Trying to execute query: " + SELECT_ALL_QUERY);
            statement.execute(SELECT_ALL_QUERY);
            ResultSet result = statement.getResultSet();
            List<IUser> users = new ArrayList<IUser>();
            while (result.next()){
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

    public IUser getUser(Integer id) {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = provider.getConnection();
            statement = connection.createStatement();
            String query = String.format(SELECT_BY_ID, id);
            LOG.info("Trying to execute query: " + query);
            statement.execute(query);
            IUser user = new User();
            ResultSet result = statement.getResultSet();
            if(!result.next())return null;
            user.setId(result.getInt(ID));
            user.setFirstName(result.getString(FIRST_NAME));
            user.setLastName(result.getString(LAST_NAME));
            user.setGender(Gender.fromBoolean(result.getBoolean(GENDER)));
            user.setEmail(result.getString(EMAIL));
            user.setLogin(result.getString(LOGIN));
            user.setPassword(result.getString(PASSWORD));
            user.setPhotoUrl(result.getString(PHOTO_URL));
            return user;
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

    public void addUser(IUser user) {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = provider.getConnection();
            statement = connection.createStatement();
            String query = String.format(ADD_USER,
                    user.getFirstName(),
                    user.getLastName(),
                    Gender.toBoolean(user.getGender()),
                    user.getEmail(),
                    user.getLogin(),
                    user.getPassword(),
                    user.getPhotoUrl());
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

    public void updateUser(IUser user) {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = provider.getConnection();
            statement = connection.createStatement();
            String query = String.format(UPDATE_USER,
                    user.getFirstName(),
                    user.getLastName(),
                    Gender.toBoolean(user.getGender()),
                    user.getEmail(),
                    user.getLogin(),
                    user.getPassword(),
                    user.getPhotoUrl(),
                    user.getId());
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

    public void deleteUser(Integer id) {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = provider.getConnection();
            statement = connection.createStatement();
            String query = String.format(DELETE_USER, id);
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
