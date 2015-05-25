package com.flatstock.model;

/**
 * Created by Valentin on 25.05.2015.
 */
public enum Sex {
    MALE("male"),
    FEMALE("female");

    String name;

    Sex(String name){
        this.name = name;
    }
}
