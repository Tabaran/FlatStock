package com.flatstock.dao;

import com.flatstock.model.IOwner;

import java.util.List;

/**
 * Created by Valentin on 26.05.2015.
 */
public interface OwnerDao {
    public List<IOwner> getAllOwners();
    public IOwner getOwner(Integer id);
    public void addOwner(IOwner owner);
    public void updateOwner(IOwner owner);
    public void deleteOwner(IOwner owner);
}
