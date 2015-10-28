package com.flatstock.repository;

import com.flatstock.dao.ReservationDao;
import com.flatstock.model.Apartment;
import com.flatstock.model.Reservation;
import com.flatstock.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import static com.flatstock.model.Id.ID;

/**
 * Created by Valentin on 22.10.2015.
 */
public class ReservationRepository extends AbstractRepository implements ReservationDao {
    @Override
    public List<Reservation> getAllReservation() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Reservation.class);
        List<Reservation> reservations = (List<Reservation>) criteria.list();
        return reservations;
    }

    @Override
    public Reservation getReservation(Integer id) {
        Criteria criteria =
                sessionFactory.getCurrentSession().createCriteria(Reservation.class).add(Restrictions.eq(ID, id));
        return  (Reservation) criteria.uniqueResult();
    }

    @Override
    public Integer addReservation(Reservation reservation) {
        return (Integer)sessionFactory.getCurrentSession().save(reservation);
    }

    @Override
    public void updateReservation(Reservation reservation) {
        addReservation(reservation);
    }

    @Override
    public void deleteReservation(Integer id) {
        Reservation reservation = new Reservation();
        reservation.setId(id);
        sessionFactory.getCurrentSession().delete(reservation);
    }
}
