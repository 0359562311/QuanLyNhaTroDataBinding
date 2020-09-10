package com.example.quanlynhatrodatabinding.model;

import com.google.gson.annotations.SerializedName;

public class Renter {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("endDate")
    private String endDate;

    public Renter(String id, String name, String endDate) {
        this.id = id;
        this.name = name;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEndDate() {
        return endDate;
    }
}
