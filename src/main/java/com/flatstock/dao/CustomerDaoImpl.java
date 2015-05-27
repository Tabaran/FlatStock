package com.flatstock.dao;

import com.flatstock.dao.CustomerDao;
import com.flatstock.model.Customer;
import com.flatstock.model.ICustomer;
import com.flatstock.utils.jdbc.ConnectionProvider;
import com.flatstock.utils.jdbc.CredentialsPropsLoader;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valentin on 27.05.2015.
 */
public class CustomerDaoImpl implements CustomerDao {
    private static final String SELECT_ALL_QUERY = "SELECT * FROM customers";
    private static final String SELECT_BY_ID = "SELECT * FROM customers WHERE id=%s";

    private static final String ID = "id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String EMAIL = "email";
    private static final String PHOTO_URL = "photo_url";

    public List<ICustomer> getAllCustomers() {
        try {
            Statement statement = ConnectionProvider.getConnection().createStatement();
            statement.execute(SELECT_ALL_QUERY);
            ResultSet result = statement.getResultSet();
            List<ICustomer> customers = new ArrayList<ICustomer>();
            while (result.next()){
                ICustomer customer = new Customer();
                customer.setId(result.getInt(ID));
                customer.setFirstName(result.getString(FIRST_NAME));
                customer.setLastName(result.getString(LAST_NAME));
                customer.setEmail(result.getString(EMAIL));
                customer.setPhotoUrl(result.getString(PHOTO_URL));
            }
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ICustomer getCustomer(Integer id) {
        try {
            Statement statement = ConnectionProvider.getConnection().createStatement();
            statement.execute(SELECT_BY_ID);
            ICustomer customer = new Customer();
            ResultSet result = statement.getResultSet();
            if(!result.first())return null;
            customer.setId(result.getInt(ID));
            customer.setFirstName(result.getString(FIRST_NAME));
            customer.setLastName(result.getString(LAST_NAME));
            customer.setEmail(result.getString(EMAIL));
            customer.setPhotoUrl(result.getString(PHOTO_URL));
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addCustomer(ICustomer customer) {

    }

    public void updateCustomer(ICustomer customer) {

    }

    public void deleteCustomer(ICustomer customer) {

    }
}
