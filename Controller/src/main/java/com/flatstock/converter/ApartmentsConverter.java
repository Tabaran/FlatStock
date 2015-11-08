package com.flatstock.converter;

import com.flatstock.service.ApartmentService;

import java.beans.PropertyEditorSupport;

/**
 * Created by Valentin on 07.11.2015.
 */
public class ApartmentsConverter extends PropertyEditorSupport {

    ApartmentService service;

    public ApartmentsConverter(){

    }

    public ApartmentsConverter(ApartmentService service){
        this.service = service;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(service.getApartment(Integer.parseInt(text)));
    }

}
