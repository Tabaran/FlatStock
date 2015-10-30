package com.flatstock.repository;

import com.flatstock.model.Apartment;
import com.flatstock.model.User;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;*/




/**
 * Created by Valentin on 22.10.2015.
 */

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:Beans.xml")
@Transactional*/

public class UserRepositoryTest {


    @Autowired
    UserRepository userRepository;

    @Autowired
    ApartmentsRepository apartmentsRepository;

    @Test
    public void test(){
        User testUser = new User();
        testUser.setLogin("L");
        Apartment apartment = new Apartment();
        apartment.setAddress("A");
        testUser.addApartment(apartment);
        userRepository.addUser(testUser);
        assertEquals("Check user was added", 1, userRepository.getAllUsers().size());
        assertEquals("Check apartments was added", 1, apartmentsRepository.getAllApartments().size());
    }

    @Test
    public void test2(){
        User testUser = new User();
        testUser.setLogin("L");
        Integer id = userRepository.addUser(testUser);
        assertEquals("", id, userRepository.getUser(id).getId());

    }





}
