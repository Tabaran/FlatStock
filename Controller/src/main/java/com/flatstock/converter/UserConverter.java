package com.flatstock.converter;

import com.flatstock.model.Gender;
import com.flatstock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.PropertyEditorSupport;

/**
 * Created by vtabaran on 11/4/2015.
 */
public class UserConverter extends PropertyEditorSupport {

    @Autowired
    UserService service;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(service.getUser(Integer.parseInt(text)));
    }

}
