package com.onlinelearningcenter.cisco.ccna1.helper;


/**
 *
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

import java.util.HashMap;

public class SessionManager {
    // LogCat tag
    private static String TAG = SessionManager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;

    Editor editor;
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "AndroidSession";

    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";


    public static final String KEY_USERNAME = "username";
    public static final String KEY_GENDER = "gender";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PHOTO = "photo";
    public static final String KEY_TOKEN = "token";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_INFORMATION = "information";
    public static final String KEY_LANGUAGE = "Indonesia";

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setLogin( String username,String gender, String email, String photo, String password, String token, String information) {

        editor.putBoolean(KEY_IS_LOGGEDIN, true);


        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_GENDER, gender);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PHOTO, photo);
        editor.putString(KEY_TOKEN, token);
        editor.putString(KEY_PASSWORD, password);
        editor.putString(KEY_INFORMATION, information);

        // commit changes
        editor.commit();

        Log.i(TAG, "User login session modified!");
    }

    public void setInformation(String token,String status_information) {



        editor.putString(KEY_TOKEN, token);
        editor.putString(KEY_INFORMATION, status_information);

        // commit changes
        editor.commit();

        Log.i(TAG, "User login session modified!");
    }



//    public void checkLogin(){
//        // Check login status
//        if(!this.isLoggedIn()){
//            Intent i = new Intent(_context, LoginActivity.class);
//            // Closing all the Activities
//            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//            // Add new Flag to start new Activity
//            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//            _context.startActivity(i);
//        }

//    }

    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();


        user.put(KEY_USERNAME, pref.getString(KEY_USERNAME, null));
        user.put(KEY_GENDER, pref.getString(KEY_GENDER, null));
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
        user.put(KEY_PHOTO, pref.getString(KEY_PHOTO, null));
        user.put(KEY_TOKEN, pref.getString(KEY_TOKEN, null));
        user.put(KEY_PASSWORD, pref.getString(KEY_PASSWORD, null));
        user.put(KEY_INFORMATION, pref.getString(KEY_INFORMATION, null));
        user.put(KEY_LANGUAGE, pref.getString(KEY_LANGUAGE, "indonesia"));

        // return user
        return user;
    }

    /**
     * Clear session details
     * */
//    public void logoutUser(){
//        // Clearing all data from Shared Preferences
//        editor.clear();
//        editor.commit();
//
//        // After logout redirect user to Loing Activity
//        Intent i = new Intent(_context, LoginActivity.class);
//        // Closing all the Activities
//        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        // Add new Flag to start new Activity
//        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//        // Staring Login Activity
//        _context.startActivity(i);
//
//        Log.i(TAG, "Session delete");
//    }

    public boolean isLoggedIn(){
        return pref.getBoolean(KEY_IS_LOGGEDIN, false);
    }

    public void createImageUser(String image){

        // Storing login value as TRUE
        editor.putString(KEY_IMAGE, image);
        editor.commit();
    }

    public HashMap<String, String> getImageUser(){
        HashMap<String, String> image = new HashMap<String, String>();

        image.put(KEY_IMAGE, pref.getString(KEY_IMAGE, null));

        return image;
    }

    public void setLanguage(String country) {

        // Storing login value as TRUE
        editor.putString(KEY_LANGUAGE, country);
        editor.commit();


    }
}
