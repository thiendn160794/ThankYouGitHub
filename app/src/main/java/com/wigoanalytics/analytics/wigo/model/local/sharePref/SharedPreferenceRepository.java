package com.wigoanalytics.analytics.wigo.model.local.sharePref;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by thiendn on 19/07/2017.
 */

public class SharedPreferenceRepository {

    private SharedPreferenceRepository() {

    }

    private static final String AUTH_KEY = "AUTHENTICATION_KEY";

    private static SharedPreferences getSharedPreference(Context ct) {
        return PreferenceManager.getDefaultSharedPreferences(ct);
    }

    public static void storeAuthenticationKey(Context context, String authenKey) {
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(AUTH_KEY, authenKey);
        editor.apply();
    }

    public static String getAuthenticationKey(Context context) {
        return getSharedPreference(context).getString(AUTH_KEY, "");
    }

    public static void clearAll(Context context) {
        SharedPreferences.Editor editor = getSharedPreference(context).edit().clear();
        editor.apply();
    }
}
