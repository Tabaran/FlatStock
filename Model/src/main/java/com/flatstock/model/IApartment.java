package com.flatstock.model;

/**
 * Created by Valentin on 25.05.2015.
 */
public interface IApartment extends Id<Integer> {
    int getPrice();
    void setPrice(int price);
    String getAddress();
    void setAddress(String address);
    int getRoomNumber();
    void setRoomNumber(int roomNumber);
    int getFloor();
    void setFloor(int floor);
    int getRating();
    void setRating(int rating);
    String getPhotoUrl();
    void setPhotoUrl(String photoUrl);
    String getDescription();
    void setDescription(String description);
    int getOwnerId();
    void setOwnerId(int ownerId);
    ApartmentsType getType();
    void setType(ApartmentsType type);
}
