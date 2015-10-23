package com.flatstock.service;

import com.flatstock.model.Apartment;

import java.util.List;

/**
 * Created by Valentin on 11.07.2015.
 */
public interface ApartmentService {
    List<Apartment> getAllApartments();
    List<Apartment> getApartmentsByOwnerId(Integer OwnerId);
    Apartment getApartment(Integer id);
    void addApartment(Apartment apartments);
    void updateApartment(Apartment apartments);
    void deleteApartment(Integer id);
}
