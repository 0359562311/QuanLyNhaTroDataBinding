package com.example.quanlynhatrodatabinding.model;


import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("account")
    private String account;
    @SerializedName("password")
    private String password;

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }
}
