package com.flatstock.model;

/**
 * Created by Valentin on 25.05.2015.
 */
public interface Person{
    String getFirstName();
    String getLastName();
    String getEmail();
    Gender getGender();
    String getPhotoUrl();
    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setEmail(String email);
    void setGender(Gender gender);
    void setPhotoUrl(String photoUrl);

}
