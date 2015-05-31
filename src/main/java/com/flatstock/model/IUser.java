package com.flatstock.model;

/**
 * Created by Valentin on 25.05.2015.
 */
public interface IUser extends Person, Id<Integer> {
    String getLogin();
    String getPassword();
    void setLogin(String login);
    void setPassword(String password);
}
