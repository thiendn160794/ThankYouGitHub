package com.wigoanalytics.analytics.wigo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thiendn on 18/07/2017.
 */

public class StringUtils {

    public static boolean isEmailValid(String email){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
