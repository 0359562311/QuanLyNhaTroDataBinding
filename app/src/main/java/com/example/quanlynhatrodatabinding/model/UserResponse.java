package com.example.quanlynhatrodatabinding.model;

import com.google.gson.annotations.SerializedName;

public class UserResponse {
    @SerializedName("error")
    private String error;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private User data;

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public User getData() {
        return data;
    }
}
