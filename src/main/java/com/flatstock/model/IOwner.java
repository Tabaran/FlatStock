package com.flatstock.model;

import java.util.List;

/**
 * Created by Valentin on 25.05.2015.
 */
public interface IOwner extends User {
    List<Integer> getApartmentsIdList();
    void addApartmentsId(Integer id);
    boolean removeApartmentsId(Integer id);
}
