package com.flatstock.utils.jdbc;

import com.flatstock.dao.credentials.Credentials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Valentin on 26.05.2015.
 */
public class ConnectionProvider {
    private static Credentials credentials;
    static {
        credentials = CredentialsPropsLoader.getCredentials(CredentialsPropsLoader.PROPERTIES_NAME);
        try {
            Class.forName(credentials.getDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(credentials.getURL(),
                    credentials.getUser(),
                    credentials.getPassword());
            return connection;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
