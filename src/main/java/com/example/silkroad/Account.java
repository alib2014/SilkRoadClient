package com.example.silkroad;

import java.util.List;

public class Account {

    private String            name;
    private String        lastName;
    private String           email;
    private String     phoneNumber;
    private String            city;
    private String        username;
    private String        password;
    private boolean   onlineStatus;
    private List<Integer> lastAdsViewed;
    private List<Integer> bookmarkedAds;
    private int databaseID;

    public Account(String name, String lastName, String email, String phoneNumber, String city, String username, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isOnlineStatus() {
        return onlineStatus;
    }

    public int getDatabaseID() {
        return databaseID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOnlineStatus(boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }
}
