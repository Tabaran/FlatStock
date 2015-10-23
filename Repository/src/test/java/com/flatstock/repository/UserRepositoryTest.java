package com.flatstock.repository;

import com.flatstock.model.Apartment;
import com.flatstock.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Valentin on 22.10.2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:Beans.xml")
@Transactional

public class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Autowired
    User user;

    @Autowired
    Apartment apartment;

    @Test
    @Rollback(false)
    public void test(){
        user.addApartment(apartment);
        System.out.println(repository.addUser(user));

    }

    @Test
    @Rollback(false)
    public void test2(){

        System.out.println(((Apartment)repository.getAllUsers().get(0).getApartments().toArray()[0]).getAddress());

    }



}
