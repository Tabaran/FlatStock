package com.flatstock.converter;

import com.flatstock.model.Gender;

import java.beans.PropertyEditorSupport;

/**
 * Created by vtabaran on 11/2/2015.
 */
public class GenderEnumConverter extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(Gender.fromString(text));
    }
}
