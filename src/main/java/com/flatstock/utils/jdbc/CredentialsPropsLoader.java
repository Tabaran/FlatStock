package com.flatstock.utils.jdbc;

import com.flatstock.dao.credentials.Credentials;
import com.flatstock.dao.credentials.CredentialsImpl;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Valentin on 26.05.2015.
 */
public class CredentialsPropsLoader {
    public static final String PROPERTIES_NAME = "db_credentials.properties";

    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final String DRIVER = "driver";
    private static final String URL = "url";

    private static Credentials credentials = null;

    public static Credentials getCredentials(String propertiesName){
        if(credentials == null) {
            Properties properties = new Properties();
            try {
                properties.load(CredentialsPropsLoader.class.getResourceAsStream(propertiesName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            credentials = new CredentialsImpl(properties.getProperty(USER),
                    properties.getProperty(PASSWORD),
                    properties.getProperty(DRIVER),
                    properties.getProperty(URL));
        }
        return credentials;
    }
}
