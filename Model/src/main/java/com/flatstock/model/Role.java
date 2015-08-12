package com.flatstock.model;

/**
 * Created by Valentin on 11.08.2015.
 */
public enum Role {
    CUSTOMER("customer"),
    ADMINISTRATOR("administrator");

    String name;

    Role(String name){
        this.name = name;
    }
    public static Role fromString(String name) {
        for (Role role: Role.values()){
            if(role.name.equals(name)) return role;
        }
        return CUSTOMER;
    }

    public String toString(){
        return name;
    }
}
