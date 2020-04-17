package com.rihat.retrofitapp.models;

import com.google.gson.JsonObject;

import java.util.List;

public class ResponseData {
    private String status;
    private JsonObject data;

    public ResponseData(String status, JsonObject person) {
        this.status = status;
        this.data = person;
    }

    public String getStatus() {
        return status;
    }

    public JsonObject getPerson() {
        return data;
    }
}
