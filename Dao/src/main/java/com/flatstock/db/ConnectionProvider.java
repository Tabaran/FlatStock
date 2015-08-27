package com.flatstock.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 * Created by Valentin on 02.06.2015.
 */
public class ConnectionProvider {
    private Logger LOG = Logger.getLogger(ConnectionProvider.class.getName());
    public Connection getConnection(){
        InitialContext initContext;
        try {
            initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource)envContext.lookup("jdbc/flatStock");
            Connection conn = ds.getConnection();
            return conn;
        }
        catch (NamingException e) {
            LOG.error(e);
        }
        catch (SQLException e) {
            LOG.error(e);
        }

        return null;
    }

}
