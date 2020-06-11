package com.rihat.retrofitapp.models;

public class Address {
    private String street;
    private String postCode;
    private String city;
    private String state;
    private String country;

    public Address(String street, String postCode, String city, String state, String country) {
        this.street = street;
        this.postCode = postCode;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
