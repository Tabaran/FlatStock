package com.flatstock.dao;

import com.flatstock.model.Apartments;

import java.util.List;

/**
 * Created by Valentin on 26.05.2015.
 */
public interface ApartmentsDao {
    public List<Apartments> getAllApartments();
    public Apartments getApartments(Integer id);
    public void addApartments(Apartments apartments);
    public void updateApartments(Apartments apartments);
    public void deleteApartments(Apartments apartments);
}
