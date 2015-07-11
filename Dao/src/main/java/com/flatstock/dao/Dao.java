package com.flatstock.dao;

import com.flatstock.db.ConnectionProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

/**
 * Created by Valentin on 11.07.2015.
 */
public class Dao {
    private ConnectionProvider provider = new ConnectionProvider();

    protected Logger LOG = Logger.getLogger(Dao.class.getName());;

    protected ResultSet executeQuery(String query){
        Statement statement = null;
        Connection connection = null;
        try {
            connection = provider.getConnection();
            statement = connection.createStatement();
            LOG.info("Execute query: " + query);
            statement.execute(query);
            return statement.getResultSet();
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
}
