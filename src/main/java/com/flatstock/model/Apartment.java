package com.flatstock.model;

/**
 * Created by Valentin on 25.05.2015.
 */
public interface Apartment extends Id<Integer> {
    int getPrice();
    void setPrice(int price);
    String getAddress();
    void setAddress(String address);
    int getRoom_number();
    void setRoom_number(int room_number);
    int getFloor();
    void setFloor(int floor);
    int getRating();
    void setRating(int rating);
    String getPhotoUrl();
    void setPhotoUrl(String photoUrl);
    String getDescription();
    void setDescription(String description);
    Owner getOwner();
    void setOwner(Owner owner);
}
