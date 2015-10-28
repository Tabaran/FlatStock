package com.flatstock.service.impl;

import com.flatstock.dao.ApartmentDao;
import com.flatstock.model.Apartment;
import com.flatstock.service.ApartmentService;

import java.util.List;


/**
 * Created by Valentin on 11.07.2015.
 */
public class ApartmentServiceImpl implements ApartmentService {

    private ApartmentDao apartmentDao;

    public List<Apartment> getAllApartments() {
        return apartmentDao.getAllApartments();
    }

    public List<Apartment> getApartmentsByOwnerId(Integer ownerId) {
        return apartmentDao.getApartmentsByOwnerId(ownerId);
    }

    public Apartment getApartment(Integer id) {
        return apartmentDao.getApartment(id);
    }

    public void addApartment(Apartment apartments) {
        apartmentDao.addApartment(apartments);
    }

    public void updateApartment(Apartment apartments) {

        apartmentDao.updateApartment(apartments);
    }

    public void deleteApartment(Integer id) {
        apartmentDao.deleteApartment(id);
    }
}
