package com.flatstock.model;

/**
 * Created by Valentin on 25.05.2015.
 */
public class Apartment implements IApartment {

    public static final String PRICE = "price";
    public static final String ADDRESS = "address";
    public static final String ROOM_NUMBER = "room_number";
    public static final String FLOOR = "floor";
    public static final String RATING = "rating";
    public static final String PHOTO_URL = "photo_url";
    public static final String TYPE = "type";
    public static final String DESCRIPTION = "description";
    public static final String OWNER_ID = "owner_id";

    private int id;
    private int price;
    private String address;
    private int roomNumber;
    private int floor;
    private int rating;
    private String photoUrl;
    private ApartmentsType type;
    private String description;
    private int ownerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int room_number) {
        this.roomNumber = room_number;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    public ApartmentsType getType() {
        return type;
    }

    public void setType(ApartmentsType type) {
        this.type = type;
    }
}
