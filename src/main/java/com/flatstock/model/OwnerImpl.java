package com.flatstock.model;

import java.util.List;

/**
 * Created by Valentin on 25.05.2015.
 */
public class OwnerImpl implements Owner, Id<Integer> {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String photoUrl;
    private Sex sex;
    private String login;
    private String password;
    private List<Apartment> apartments;

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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public Apartment getApartmentsById(int id) {
        for(Apartment apartment: apartments){
            if(apartment.getId() == id) return apartment;
        }
        return null;
    }

    public void addApartments(Apartment apartment) {
        this.apartments.add(apartment);
    }

    public boolean removeApartments(int id) {
        for(Apartment apartment: apartments){
            if(apartment.getId() == id) return apartments.remove(apartment);
        }
        return false;
    }
}
