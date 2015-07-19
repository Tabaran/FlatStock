package com.flatstock.service;

import com.flatstock.dao.ApartmentDao;
import com.flatstock.dao.ApartmentDaoImpl;
import com.flatstock.model.IApartment;
import java.util.List;


/**
 * Created by Valentin on 11.07.2015.
 */
public class ApartmentServiceImpl implements ApartmentService {

    private ApartmentDao apartmentDao = new ApartmentDaoImpl();

    public List<IApartment> getAllApartments() {
        return apartmentDao.getAllApartments();
    }

    public List<IApartment> getApartmentsByOwnerId(Integer ownerId) {
        return apartmentDao.getApartmentsByOwnerId(ownerId);
    }

    public IApartment getApartment(Integer id) {
        return apartmentDao.getApartment(id);
    }

    public void addApartment(IApartment apartments) {
        apartmentDao.addApartment(apartments);
    }

    public void updateApartment(IApartment apartments) {

        apartmentDao.updateApartment(apartments);
    }

    public void deleteApartment(Integer id) {
        apartmentDao.deleteApartment(id);
    }
}
