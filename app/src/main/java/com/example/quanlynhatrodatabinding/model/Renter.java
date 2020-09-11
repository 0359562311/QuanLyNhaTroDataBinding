package com.example.quanlynhatrodatabinding.model;

import com.google.gson.annotations.SerializedName;

public class Renter {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;


    public Renter(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
