package com.wigoanalytics.analytics.wigo.model.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by thiendn on 27/07/2017.
 */

public class Contact {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("avatar")
    private String avatar;
    @SerializedName("position")
    private String position;
    @SerializedName("email")
    private String email;
    @SerializedName("utype")
    private int uType;
    @SerializedName("phone")
    private String phone;
    @SerializedName("note")
    private String note;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public int getuType() {
        return uType;
    }

    public String getPhone() {
        return phone;
    }

    public String getNote() {
        return note;
    }
}
