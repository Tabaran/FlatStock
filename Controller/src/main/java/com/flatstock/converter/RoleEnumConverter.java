package com.flatstock.converter;

import com.flatstock.model.Role;

import java.beans.PropertyEditorSupport;

/**
 * Created by vtabaran on 11/2/2015.
 */
public class RoleEnumConverter extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(Role.fromString(text));
    }
}
