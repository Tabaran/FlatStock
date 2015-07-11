package com.flatstock.service;

import com.flatstock.dao.ApartmentDao;
import com.flatstock.dao.ApartmentDaoImpl;
import com.flatstock.model.Apartment;
import com.flatstock.model.ApartmentsType;
import com.flatstock.model.IApartment;
import org.apache.log4j.Logger;
import static com.flatstock.dao.ApartmentDaoImpl.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Valentin on 11.07.2015.
 */
public class ApartmentServiceImpl implements ApartmentService {

    static Logger LOG = Logger.getLogger(ApartmentServiceImpl.class.getName());

    private ApartmentDao apartmentDao = new ApartmentDaoImpl();

    public List<IApartment> getAllApartments() {
        ResultSet result = apartmentDao.getAllApartments();
        List<IApartment> apartments = new ArrayList<IApartment>();
        try {
            while (result.next()){
                IApartment apartment = new Apartment();
                apartment.setId(result.getInt(ID));
                apartment.setAddress(result.getString(ADDRESS));
                apartment.setRoomNumber(result.getInt(ROOM_NUMBER));
                apartment.setFloor(result.getInt(FLOOR));
                apartment.setPrice(result.getInt(PRICE));
                apartment.setRating(result.getInt(RATING));
                apartment.setOwnerId(result.getInt(OWNER_ID));
                apartment.setType(ApartmentsType.fromString(result.getString(TYPE)));
                apartment.setDescription(result.getString(DESCRIPTION));
                apartment.setPhotoUrl(result.getString(PHOTO_URL));
                apartments.add(apartment);
            }
        } catch (SQLException e) {
            LOG.error(e);
        }
        return apartments;
    }

    public List<IApartment> getApartmentsByOwnerId(Integer ownerId) {
        ResultSet result = apartmentDao.getApartmentsByOwnerId(ownerId);
        List<IApartment> apartments = new ArrayList<IApartment>();
        try {
            while (result.next()){
                IApartment apartment = new Apartment();
                apartment.setId(result.getInt(ID));
                apartment.setAddress(result.getString(ADDRESS));
                apartment.setRoomNumber(result.getInt(ROOM_NUMBER));
                apartment.setFloor(result.getInt(FLOOR));
                apartment.setPrice(result.getInt(PRICE));
                apartment.setRating(result.getInt(RATING));
                apartment.setOwnerId(result.getInt(OWNER_ID));
                apartment.setType(ApartmentsType.fromString(result.getString(TYPE)));
                apartment.setDescription(result.getString(DESCRIPTION));
                apartment.setPhotoUrl(result.getString(PHOTO_URL));
                apartments.add(apartment);
            }
        } catch (SQLException e) {
            LOG.error(e);
        }
        return apartments;
    }

    public IApartment getApartment(Integer id) {
        ResultSet result = apartmentDao.getApartment(id);
        IApartment apartment = new Apartment();
        try {
            if(!result.next())return null;
            apartment.setId(result.getInt(ID));
            apartment.setAddress(result.getString(ADDRESS));
            apartment.setRoomNumber(result.getInt(ROOM_NUMBER));
            apartment.setFloor(result.getInt(FLOOR));
            apartment.setPrice(result.getInt(PRICE));
            apartment.setRating(result.getInt(RATING));
            apartment.setOwnerId(result.getInt(OWNER_ID));
            apartment.setType(ApartmentsType.fromString(result.getString(TYPE)));
            apartment.setDescription(result.getString(DESCRIPTION));
            apartment.setPhotoUrl(result.getString(PHOTO_URL));
        } catch (SQLException e) {
            LOG.error(e);
        }
        return apartment;
    }

    public void addApartment(IApartment apartments) {
        Map<String, String> params = new HashMap<String, String>();
        params.put(ADDRESS, apartments.getAddress());
        params.put(DESCRIPTION, apartments.getDescription());
        params.put(PHOTO_URL, apartments.getPhotoUrl());
        params.put(FLOOR, String.valueOf(apartments.getFloor()));
        params.put(PRICE, String.valueOf(apartments.getPrice()));
        params.put(RATING, String.valueOf(apartments.getRating()));
        params.put(OWNER_ID, String.valueOf(apartments.getOwnerId()));
        params.put(ROOM_NUMBER, String.valueOf(apartments.getRoomNumber()));
        apartmentDao.addApartment(params);
    }

    public void updateApartment(IApartment apartments) {
        Map<String, String> params = new HashMap<String, String>();
        params.put(ID, apartments.getId().toString());
        params.put(ADDRESS, apartments.getAddress());
        params.put(DESCRIPTION, apartments.getDescription());
        params.put(PHOTO_URL, apartments.getPhotoUrl());
        params.put(FLOOR, String.valueOf(apartments.getFloor()));
        params.put(PRICE, String.valueOf(apartments.getPrice()));
        params.put(RATING, String.valueOf(apartments.getRating()));
        params.put(OWNER_ID, String.valueOf(apartments.getOwnerId()));
        params.put(ROOM_NUMBER, String.valueOf(apartments.getRoomNumber()));
        params.put(TYPE, apartments.getType().toString());
        apartmentDao.updateApartment(params);
    }

    public void deleteApartment(Integer id) {
        apartmentDao.deleteApartment(id);
    }
}
