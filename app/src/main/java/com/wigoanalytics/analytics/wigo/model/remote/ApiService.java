package com.wigoanalytics.analytics.wigo.model.remote;

import com.wigoanalytics.analytics.wigo.model.dto.Contact;
import com.wigoanalytics.analytics.wigo.model.dto.ResponseGetNewPassword;
import com.wigoanalytics.analytics.wigo.model.dto.Session;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by thiendn on 20/07/2017.
 */

public interface ApiService {

    @GET("webservicenative/login")
    Call<Session> login(@Query("username") String username,
                        @Query("password") String password,
                        @Query("type") String type,
                        @Query("device") String device);

    @GET("login/forgotpassword")
    Call<ResponseGetNewPassword> getNewPassword(@Query("email") String email);

    @GET("webserviceauth/getcontactv2")
    Call<List<Contact>> getAllContact(@Header("auth_key") String authKey);
}
