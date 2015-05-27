package com.flatstock.utils.jdbc;

import com.flatstock.dao.credentials.Credentials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Valentin on 26.05.2015.
 */
public class ConnectionProvider {
    private static Connection connection = null;


    public static Connection getConnection() {
        if (connection == null) {
            Credentials credentials = CredentialsPropsLoader.getCredentials(CredentialsPropsLoader.PROPERTIES_NAME);
            try {
                Class.forName(credentials.getDriver());
                connection = DriverManager.getConnection(credentials.getURL(),
                        credentials.getUser(),
                        credentials.getPassword());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
