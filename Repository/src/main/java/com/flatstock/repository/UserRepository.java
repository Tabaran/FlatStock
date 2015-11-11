package com.flatstock.repository;

import com.flatstock.dao.UserDao;
import com.flatstock.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import static com.flatstock.model.Id.*;
import static com.flatstock.model.User.*;
import java.util.List;

/**
 * Created by Valentin on 21.10.2015.
 */


public class UserRepository implements UserDao {

    SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<User> getAllUsers() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        List<User> users = (List<User>) criteria.list();
        return users;
    }

    @Override
    public User getUser(Integer id) {
        Criteria criteria =
                sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq(ID, id));
        return  (User) criteria.uniqueResult();
    }

    @Override
    public User getUserByLogin(String login) {
        Criteria criteria =
                sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq(LOGIN, login));
        return  (User) criteria.uniqueResult();
    }

    @Override
    public Integer addUser(User user) {
        return (Integer)sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void deleteUser(Integer id) {
        User user = new User();
        user.setId(id);
        sessionFactory.getCurrentSession().delete(user);
    }
}
