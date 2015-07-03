package com.flatstock.dao;

import com.flatstock.model.IApartment;

import java.util.List;

/**
 * Created by Valentin on 26.05.2015.
 */
public interface ApartmentDao {
    List<IApartment> getAllApartments();
    List<IApartment> getApartmentsByOwnerId(Integer OwnerId);
    IApartment getApartment(Integer id);
    void addApartment(IApartment apartments);
    void updateApartment(IApartment apartments);
    void deleteApartment(Integer id);
}
