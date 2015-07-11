package com.flatstock.model;

/**
 * Created by Valentin on 25.05.2015.
 */
public interface Id<T> {

    final static String ID = "id";

    T getId();
    void setId(T id);
}
