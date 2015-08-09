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
    public static Gender fromString(String name) {
        if (name.equalsIgnoreCase("male")) return MALE;
        else return FEMALE;
    }

    public static boolean toBoolean(Gender gender){
        if(gender.name.equals("male")) return true;
        return false;
    }

    public static Gender fromBoolean(boolean gender){
        if(gender) return Gender.MALE;
        return Gender.FEMALE;
    }
}
