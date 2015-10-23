package com.flatstock.repository;

import com.flatstock.dao.UserDao;
import com.flatstock.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.flatstock.model.Id.*;

import java.util.List;

/**
 * Created by Valentin on 21.10.2015.
 */
@Repository
public class UserRepository implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        List<User> users = (List<User>) criteria.list();
        return users;
    }

    @Override
    public User getUser(Integer id) {
        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq(ID, id));
        User users = (User) criteria.uniqueResult();
        session.getTransaction().commit();
        return users;
    }

    @Override
    public Integer addUser(User user) {
        Session session = getSessionFactory().getCurrentSession();
        return (Integer)session.save(user);

    }

    @Override
    public void updateUser(User user) {
        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public void deleteUser(Integer id) {
        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = new User();
        session.delete(user);
        session.getTransaction().commit();
    }
}
