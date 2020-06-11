package com.rihat.retrofitapp.models;

public class Employement {
    private boolean emplymentstatus;
    private String profession;

    public Employement(boolean emplymentstatus, String profession) {
        this.emplymentstatus = emplymentstatus;
        this.profession = profession;
    }

    public Employement() {
    }

    public boolean isEmplymentstatus() {
        return emplymentstatus;
    }

    public void setEmplymentstatus(boolean emplymentstatus) {
        this.emplymentstatus = emplymentstatus;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
