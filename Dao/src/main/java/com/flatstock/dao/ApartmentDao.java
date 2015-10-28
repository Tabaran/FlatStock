package com.flatstock.dao;

import com.flatstock.model.Apartment;

import java.util.List;

/**
 * Created by Valentin on 26.05.2015.
 */
public interface ApartmentDao {
    List<Apartment> getAllApartments();
    List<Apartment> getApartmentsByOwnerId(Integer OwnerId);
    Apartment getApartment(Integer id);
    Integer addApartment(Apartment apartments);
    void updateApartment(Apartment apartments);
    void deleteApartment(Integer id);
}
