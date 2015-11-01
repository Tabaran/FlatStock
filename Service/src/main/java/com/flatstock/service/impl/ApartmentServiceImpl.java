package com.flatstock.service.impl;

import com.flatstock.dao.ApartmentDao;
import com.flatstock.model.Apartment;
import com.flatstock.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import java.util.List;


/**
 * Created by Valentin on 11.07.2015.
 */

@Transactional
public class ApartmentServiceImpl implements ApartmentService {

    @Autowired
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
