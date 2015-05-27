package com.flatstock.dao;

import com.flatstock.model.ICustomer;

import java.util.List;

/**
 * Created by Valentin on 26.05.2015.
 */
public interface CustomerDao {
    public List<ICustomer> getAllCustomers();
    public ICustomer getCustomer(Integer id);
    public void addCustomer(ICustomer customer);
    public void updateCustomer(ICustomer customer);
    public void deleteCustomer(ICustomer customer);
}
