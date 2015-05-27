package com.flatstock.dao.credentials;

/**
 * Created by Valentin on 26.05.2015.
 */
public class CredentialsImpl implements Credentials {
    private String driver;
    private String user;
    private String password;
    private String url;

    public CredentialsImpl(String user, String password, String driver, String url){
        this.url = url;
        this.user = user;
        this.password = password;
        this.driver = driver;
    }

    public String getDriver() {
        return driver;
    }

    public String getURL() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
