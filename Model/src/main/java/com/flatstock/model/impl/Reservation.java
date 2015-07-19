package com.flatstock.model.impl;

import com.flatstock.model.IReservation;

import java.util.Date;

/**
 * Created by Valentin on 31.05.2015.
 */
public class Reservation implements IReservation {

    public static final String RESERVATIONS = "reservations";

    public static final String USER_ID = "user_id";
    public static final String APARTMENT_ID = "apartment_id";
    public static final String START_TIME = "start_time";
    public static final String END_TIME = "end_time";

    private Integer id;
    private Integer userId;
    private Integer apartmentId;
    private Date startTime;
    private Date endTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
    this.id= id;
    }
}
