package com.flatstock.model;

import java.util.Date;

/**
 * Created by Valentin on 31.05.2015.
 */
public interface IReservation extends Id<Integer>{
    Integer getUserId();
    void setUserId(Integer userId);
    Integer getApartmentId();
    void setApartmentId(Integer apartmentId);
    Date getStartTime();
    void setStartTime(Date startTime);
    Date getEndTime();
    void setEndTime(Date endTime);
    Integer getId();
    void setId(Integer id);

}
