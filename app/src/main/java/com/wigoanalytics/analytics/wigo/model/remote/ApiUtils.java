package com.wigoanalytics.analytics.wigo.model.remote;

/**
 * Created by thiendn on 18/07/2017.
 */

public class ApiUtils {

    private ApiUtils() {}

    private static final String BASE_URL = "https://wigo.tech/";
    private static final String WEB_SERVICE_NATIVE_URL = "webservicenative/";

    public static ApiService getApiService(){
        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}
