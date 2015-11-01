package com.flatstock.model;

import javax.persistence.*;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Valentin on 25.05.2015.
 */

@Entity
@Table(name = "users")
public class User implements Person, com.flatstock.model.Id<Integer>,Serializable {

    public static final String USERS = "users";
    public static final String USER = "user";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String EMAIL = "email";
    public static final String PHOTO_URL = "photo_url";
    public static final String GENDER = "gender";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String ROLE = "role";


    @Id
    @GeneratedValue
    @Column(name = ID)
    private Integer id;

    @Column(name = FIRST_NAME)
    private String firstName;

    @Column(name = LAST_NAME)
    private String lastName;

    @Column(name = EMAIL)
    private String email;

    @Column(name = PHOTO_URL)
    private String photoUrl;

    @Column(name = GENDER)
    private Gender gender;

    @Column(name = LOGIN)
    private String login;

    @Column(name = PASSWORD)
    private String password;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "owner_id")
    Set<Apartment> apartments = new HashSet<>();

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "reservation_id")
    Set<Reservation> reservations = new HashSet<>();

    private Role role = Role.CUSTOMER;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }


    public Set<Apartment> getApartments() {
        return apartments;
    }


    public Set<Reservation> getReservation() {
        return reservations;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public void addApartment(Apartment apartment) {
        apartments.add(apartment);
    }


    public void removeApartment(Apartment apartment) {
        apartments.remove(apartment);
    }


    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }


    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

}
