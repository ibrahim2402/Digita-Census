package com.rihat.retrofitapp.models;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Person {
    private int id;
    @SerializedName("name")
    private String fullname;
    private String address;
    private int age;
    private String gender;
    private String ssn;


    public Person(int id, String fullname, String address, int age, String gender, String ssn) {
        this.id = id;
        this.fullname = fullname;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.ssn = ssn;
    }

    public int getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getSsn() {
        return ssn;
    }

}
