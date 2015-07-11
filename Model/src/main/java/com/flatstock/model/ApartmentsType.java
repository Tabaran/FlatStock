package com.flatstock.model;

/**
 * Created by Valentin on 31.05.2015.
 */
public enum ApartmentsType {
    ROOM("room"),
    FLAT("flat"),
    HOUSE("house"),
    UNKNOWN("");

    private String name;

    ApartmentsType(String name){
        this.name = name;
    }
    public static ApartmentsType fromString(String name) {
        for (ApartmentsType type: ApartmentsType.values()) {
            if (name.equals(type.name)) return type;
        }
        return UNKNOWN;
    }
}
