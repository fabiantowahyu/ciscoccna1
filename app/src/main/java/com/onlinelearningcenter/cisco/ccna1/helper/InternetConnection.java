package com.onlinelearningcenter.cisco.ccna1.helper;

/**
 * Created by Dito on 12/8/2016.
 */

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;

public class InternetConnection {

    /**
     * CHECK WHETHER INTERNET CONNECTION IS AVAILABLE OR NOT
     */
    public static boolean checkConnection(@NonNull Context context) {
        return ((ConnectivityManager) context.getSystemService
                (Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }
}
