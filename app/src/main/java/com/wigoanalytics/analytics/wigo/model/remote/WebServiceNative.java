package com.wigoanalytics.analytics.wigo.model.remote;

import com.wigoanalytics.analytics.wigo.model.dto.Session;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by thiendn on 18/07/2017.
 */

public interface WebServiceNative {

    @GET("login")
    Call<Session> login(@Query("username") String username,
                        @Query("password") String password,
                        @Query("type") String type,
                        @Query("device") String device);
}
