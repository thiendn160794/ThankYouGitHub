package com.wigoanalytics.analytics.wigo.model.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by thiendn on 20/07/2017.
 */

public class ResponseGetNewPassword {
    @SerializedName("success")
    private int isSuccess;
    @SerializedName("msg")
    private String msg;

    public int getIsSuccess() {
        return isSuccess;
    }

    public String getMsg() {
        return msg;
    }
}
