package com.flatstock.dao.impl;

import com.flatstock.dao.UrlDao;
import static com.flatstock.model.Id.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valentin on 16.08.2015.
 */
public class UrlDaoImpl implements UrlDao {
    private static final String URL_TABLE = "Url";
    private static final String URL = "url";

    private static final String SELECT_URLS = "SELECT * FROM " + URL_TABLE + ";";
    private static final String SELECT_URL_ID = "SELECT " + ID + " FROM " + URL_TABLE + " WHERE " + URL + "=?;";
    private static final String ADD_URL = "INSERT INTO " + URL_TABLE +
            "(" + URL + ") VALUES (?);";
    private static final String REMOVE_URL = "DELETE FROM " + URL_TABLE + " WHERE " + URL + "=?;";


    public Map<Integer, String> getAllUrls() {
        Dao<Map<Integer,String>> dao = new Dao<Map<Integer, String>>() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {

            }

            @Override
            public Map<Integer, String> execute(ResultSet result) throws SQLException {
                Map<Integer, String> urlMap = new HashMap<Integer, String>();
                while (result.next()){
                    urlMap.put(result.getInt(ID), result.getString(URL));
                }
                return urlMap;
            }
        };
        return dao.executeQuery(SELECT_URLS);
    }

    public int getUrlId(final String url) {
        Dao<Integer> dao = new Dao<Integer>() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setString(1, url);
            }

            @Override
            public Integer execute(ResultSet result) throws SQLException {
                if (!result.next()) return null;
                return result.getInt(ID);
            }
        };
        return dao.executeQuery(SELECT_URL_ID);
    }

    public void addUrl(final String url) {
        Dao dao = new Dao() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setString(1, url);
            }

            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        dao.executeQuery(ADD_URL);
    }

    public void removeUrl(final String url) {
        Dao dao = new Dao() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
                statement.setString(1, url);
            }

            @Override
            public Object execute(ResultSet result) throws SQLException {
                return null;
            }
        };
        dao.executeQuery(REMOVE_URL);
    }
}
