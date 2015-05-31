package com.flatstock.dao;

import com.flatstock.model.IApartment;

import java.util.List;

/**
 * Created by Valentin on 26.05.2015.
 */
public interface ApartmentDao {
    public List<IApartment> getAllApartments();
    public List<IApartment> getApartmentsByOwnerId(Integer OwnerId);
    public IApartment getApartment(Integer id);
    public void addApartment(IApartment apartments);
    public void updateApartment(IApartment apartments);
    public void deleteApartment(Integer id);
}
