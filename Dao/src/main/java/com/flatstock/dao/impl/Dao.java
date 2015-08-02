package com.flatstock.dao.impl;

import com.flatstock.db.ConnectionProvider;

import java.sql.*;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Created by Valentin on 11.07.2015.
 */
public abstract class Dao<T> {
    private ConnectionProvider provider = new ConnectionProvider();

    protected Logger LOG = Logger.getLogger(Dao.class.getName());;

    protected T executeQuery(String query){
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = provider.getConnection();
            statement = connection.prepareStatement(query);
            LOG.info("Execute query: " + query);
            prepare(statement);
            statement.execute();
            return execute(statement.getResultSet());
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

    public  abstract void prepare(PreparedStatement statement) throws SQLException;

    public abstract T execute(ResultSet result) throws SQLException;
}
