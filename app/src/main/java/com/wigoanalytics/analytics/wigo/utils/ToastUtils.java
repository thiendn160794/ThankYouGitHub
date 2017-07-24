package com.wigoanalytics.analytics.wigo.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by thiendn on 19/07/2017.
 */

public class ToastUtils {
    public static void showShortToast(Context context, String msg){
        if (msg == null || msg.equals("")) return;
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
    public static void showLongToast(Context context, String msg){
        if (msg == null || msg.equals("")) return;
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
