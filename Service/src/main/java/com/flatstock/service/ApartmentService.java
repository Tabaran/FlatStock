package com.flatstock.service;

import com.flatstock.model.IApartment;

import java.util.List;

/**
 * Created by Valentin on 11.07.2015.
 */
public interface ApartmentService {
    List<IApartment> getAllApartments();
    List<IApartment> getApartmentsByOwnerId(Integer OwnerId);
    IApartment getApartment(Integer id);
    void addApartment(IApartment apartments);
    void updateApartment(IApartment apartments);
    void deleteApartment(Integer id);
}
