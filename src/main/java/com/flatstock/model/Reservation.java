package com.flatstock.model;

import java.util.Date;

/**
 * Created by Valentin on 31.05.2015.
 */
public class Reservation implements IReservation {

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
