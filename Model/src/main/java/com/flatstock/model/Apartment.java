package com.flatstock.model;

import javax.persistence.*;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Set;


/**
 * Created by Valentin on 25.05.2015.
 */
@Entity
@Table(name = "apartments")
public class Apartment implements com.flatstock.model.Id<Integer>, Serializable {

    public static final String APARTMENTS = "apartments";
    public static final String APARTMENT = "apartment";

    public static final String PRICE = "price";
    public static final String ADDRESS = "address";
    public static final String ROOM_NUMBER = "roomNumber";
    public static final String FLOOR = "floor";
    public static final String RATING = "rating";
    public static final String PHOTO_URL = "photoUrl";
    public static final String TYPE = "type";
    public static final String DESCRIPTION = "description";
    public static final String OWNER = "owner";


    @Id
    @Column(name = ID)
    @GeneratedValue
    private int id;

    @Column(name = PRICE)
    private int price;

    @Column(name = ADDRESS)
    private String address;

    @Column(name = ROOM_NUMBER)
    private int roomNumber;

    @Column(name = FLOOR)
    private int floor;

    @Column(name = RATING)
    private int rating;

    @Column(name = PHOTO_URL)
    private String photoUrl;

    @Column(name = TYPE)
    private ApartmentsType type;

    @Column(name = DESCRIPTION)
    private String description;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name="apartment_id")
    Set<Reservation> reservations;

    @OneToOne(cascade = {CascadeType.ALL})
    User owner;


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

    public ApartmentsType getType() {
        return type;
    }

    public void setType(ApartmentsType type) {
        this.type = type;
    }


    public User getOwner() {
        return owner;
    }


    public void setOwner(User owner) {
        this.owner = owner;
    }


    public Set<Reservation> getReservations() {
        return reservations;
    }


    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }


    public void removeReservation(Reservation reservation) {
        this.reservations.remove(reservation);
    }
}
