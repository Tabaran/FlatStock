package com.flatstock.model;

import javax.persistence.*;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Valentin on 31.05.2015.
 */

@Entity
@Table(name = "reservations")
public class Reservation implements com.flatstock.model.Id<Integer>,Serializable {

    public static final String RESERVATIONS = "reservations";
    public static final String RESERVATION = "reservation";

    public static final String START_TIME = "startTime";
    public static final String END_TIME = "endTime";

    @GeneratedValue
    @Id
    @Column(name = ID)
    private Integer id;

    @Column(name = START_TIME)
    private Date startTime;

    @Column(name = END_TIME)
    private Date endTime;

    @ManyToOne()
    private Apartment apartment;

    @ManyToOne()
    private User user;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


    public Apartment getApartment() {
        return apartment;
    }


    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
    this.id= id;
    }
}
