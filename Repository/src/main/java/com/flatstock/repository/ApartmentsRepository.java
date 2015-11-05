package com.flatstock.repository;

import com.flatstock.dao.ApartmentDao;
import com.flatstock.model.Apartment;
import com.flatstock.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import static com.flatstock.model.Id.ID;

/**
 * Created by Valentin on 22.10.2015.
 */
public class ApartmentsRepository extends AbstractRepository implements ApartmentDao {



    @Override
    public List<Apartment> getAllApartments() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Apartment.class);
        List<Apartment> apartments = (List<Apartment>) criteria.list();
        return apartments;
    }

    @Override
    public List<Apartment> getApartmentsByOwnerId(Integer ownerId) {
        Criteria criteria =
                sessionFactory.getCurrentSession().createCriteria(Apartment.class).add(Restrictions.eq(ID, ownerId));
        return  (List<Apartment>) criteria.list();
    }

    @Override
    public Apartment getApartment(Integer id) {
        Criteria criteria =
                sessionFactory.getCurrentSession().createCriteria(Apartment.class).add(Restrictions.eq(ID, id));
        return  (Apartment) criteria.uniqueResult();
    }

    @Override
    public Integer addApartment(Apartment apartment) {
        return (Integer)sessionFactory.getCurrentSession().save(apartment);
    }

    @Override
    public void updateApartment(Apartment apartment) {
        sessionFactory.getCurrentSession().update(apartment);
    }

    @Override
    public void deleteApartment(Integer id) {
        Apartment apartment = new Apartment();
        apartment.setId(id);
        sessionFactory.getCurrentSession().delete(apartment);
    }
}
