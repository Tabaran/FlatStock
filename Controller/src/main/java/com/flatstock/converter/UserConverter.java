package com.flatstock.converter;


import com.flatstock.service.UserService;


import java.beans.PropertyEditorSupport;

/**
 * Created by vtabaran on 11/4/2015.
 */
public class UserConverter extends PropertyEditorSupport {


    UserService service;


    public UserConverter(UserService service) {
        this.service = service;
    }

    public UserConverter() {

    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(service.getUser(Integer.parseInt(text)));
    }

}
