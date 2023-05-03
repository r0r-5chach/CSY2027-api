package com.r0r5chach.entities.user;

public class Address {
    private int houseNumber;
    private String street, city, postCode;

    public Address(int houseNumber, String street, String city, String postCode) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.postCode = postCode;
    }

    public int getHouseNumber() {
        return houseNumber;
    }
    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPostCode() {
        return postCode;
    }
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String toString() {
        return houseNumber + " " + street + ", " + city + ", " + postCode;
    }
}
