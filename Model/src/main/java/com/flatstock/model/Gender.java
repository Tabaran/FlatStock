package com.flatstock.model;

/**
 * Created by Valentin on 25.05.2015.
 */
public enum Gender {
    MALE("male"),
    FEMALE("female");

    String name;

    Gender(String name){
        this.name = name;
    }
    public static Gender fromString(String name) throws IllegalArgumentException{
        if(name == null) throw new IllegalArgumentException();
        if(name.equalsIgnoreCase(FEMALE.name)) return FEMALE;
        if (name.equalsIgnoreCase(MALE.name)) return MALE;
        throw new IllegalArgumentException();
    }

    public String toString(){
        return name;
    }
}
