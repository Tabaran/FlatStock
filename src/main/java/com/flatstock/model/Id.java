package com.flatstock.model;

/**
 * Created by Valentin on 25.05.2015.
 */
public interface Id<T> {
    T getId();
    void setId(T id);
}