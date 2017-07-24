package com.wigoanalytics.analytics.wigo.model.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by thiendn on 19/07/2017.
 */

public class Session {
    @SerializedName("auth_key")
    private String authKey;

    public String getAuthKey() {
        return authKey;
    }
}
