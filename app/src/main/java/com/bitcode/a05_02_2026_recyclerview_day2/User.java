package com.bitcode.a05_02_2026_recyclerview_day2;

import androidx.annotation.NonNull;

public class User{
    int userId;
    String username;


    public User(){
        this.userId = 10032;
        this.username = "Ashish";
    }

    public User(int uId, String uName){
        this.userId = uId;
        this.username = uName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NonNull
    @Override
    public String toString() {
        return "user id : " + userId + " " + "user name : " + username;
    }
}
