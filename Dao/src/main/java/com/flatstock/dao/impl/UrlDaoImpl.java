package com.flatstock.dao.impl;

import com.flatstock.dao.UrlDao;
import static com.flatstock.model.Id.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Valentin on 16.08.2015.
 */
public class UrlDaoImpl implements UrlDao {
    private static final String URL_TABLE = "URLS";
    private static final String URL = "url";
    private static final String GROUP_ID = "group_id";
    private static final String SELECT_URLS = "SELECT * FROM " + URL_TABLE + ";";

    public Map<String, Integer> getAllUrls() {
        Dao<Map<String, Integer>> dao = new Dao<Map<String, Integer>>() {
            @Override
            public void prepare(PreparedStatement statement) throws SQLException {
            }

            @Override
            public Map<String, Integer> execute(ResultSet result) throws SQLException {
                Map<String, Integer> urlMap = new HashMap<>();
                while (result.next()){
                    urlMap.put(result.getString(URL), result.getInt(GROUP_ID));
                }
                return urlMap;
            }
        };
        return dao.executeQuery(SELECT_URLS);
    }
}
