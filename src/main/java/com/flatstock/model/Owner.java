package com.flatstock.model;

import java.util.List;

/**
 * Created by Valentin on 25.05.2015.
 */
public interface Owner extends User {
    List<Apartment> getApartments();
    Apartment getApartmentsById(int id);
    void addApartments(Apartment apartments);
    boolean removeApartments(int id);
}
