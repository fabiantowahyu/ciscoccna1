package com.onlinelearningcenter.cisco.ccna1;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;


import com.onlinelearningcenter.cisco.R;
import com.onlinelearningcenter.cisco.ccna1.Rest.RestApi;
import com.onlinelearningcenter.cisco.ccna1.config.SpiritConfig;
import com.onlinelearningcenter.cisco.ccna1.helper.InternetConnection;
import com.onlinelearningcenter.cisco.ccna1.helper.SessionManager;
import com.onlinelearningcenter.cisco.ccna1.helper.SharedPrefManager;
import com.onlinelearningcenter.cisco.ccna1.pojo.DevicesResponses;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreen extends AppCompatActivity {
    SessionManager session;
    String token;
    private static final String TAG = "SplashScreen";
    private String language;
    private ImageView splash_background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        session = new SessionManager(getApplicationContext());
        HashMap<String, String> user = session.getUserDetails();

        language = user.get(SessionManager.KEY_LANGUAGE);

        setContentView(R.layout.activity_splash_screen);


        splash_background = (ImageView)findViewById(R.id.splash_background);


            splash_background.setImageDrawable(getResources().getDrawable(R.drawable.splash_ccna1));

       token = SharedPrefManager.getInstance(this).getDeviceToken();

        Log.d(TAG, "Refreshed token: " + token);
//        Toast.makeText(getApplicationContext(), token, Toast.LENGTH_LONG).show();
//        session = new SessionManager(getApplicationContext());
//        if(session.isLoggedIn()){
//            HashMap<String, String> user = session.getUserDetails();
//            v_emp_id = user.get(SessionManager.KEY_EMP_ID);
//        }else{
//            v_emp_id = "";
//        }

        checkUpdate();
    }

    @Override
    protected void onPause() {

        super.onPause();
        finish();
    }


    protected void checkUpdate() {

        token = SharedPrefManager.getInstance(this).getDeviceToken();

        if (InternetConnection.checkConnection(getApplicationContext())) {
            RestApi request = SpiritConfig.getInterfaceService();
            Call<DevicesResponses> mService = request.getUpdate("test",token);
            mService.enqueue(new Callback<DevicesResponses>() {
                @Override
                public void onResponse(Call<DevicesResponses> call, Response<DevicesResponses> response) {

                    DevicesResponses responses = response.body();


                    int returnedResponse = responses.getSuccess();
                    String update_link = responses.getUpdate_link();
                    String is_superior = responses.getisSuperior();
                    String email = responses.getEmail();
                    String information = responses.getInformation();

                    session = new SessionManager(getApplicationContext());


                    session.setInformation(token,information);

                    Log.i("Message", "Returned " + returnedResponse);

                    if (returnedResponse == 1) {
                        startUpdate(update_link);

                    } else if (returnedResponse == 0) {
                        startApp();

                    }
                }

                @Override
                public void onFailure(Call<DevicesResponses> call, Throwable t) {
                    call.cancel();
                    Toast.makeText(SplashScreen.this, "Please check your network connection and internet permission", Toast.LENGTH_LONG).show();
                }
            });
        } else {
            Toast.makeText(SplashScreen.this, "Please check your network connection and internet permission", Toast.LENGTH_LONG).show();

        }
    }

    private void startUpdate(final String update_link) {
        new AlertDialog.Builder(SplashScreen.this)
                .setTitle("Update Belajar Komputer !")
                .setMessage("Hai, untuk meningkatkan performa dan fitur silahkan diupdate Aplikasi Belajar Komputernya yaa !")
                .setIcon(R.drawable.alert_outline)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {


                        Intent viewIntent =
                                new Intent("android.intent.action.VIEW",
                                        Uri.parse(update_link));
                        startActivity(viewIntent);



                    }
                })

                .show();

    }

    private void startApp() {
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {



                        Intent i = new Intent(getApplicationContext(), MainActivity.class);


                        startActivity(i);


                }
            }
        };
        timer.start();


    }

//    private void updateSuperiorStatus(String is_superior) {
//
//        if (session.isLoggedIn()) {
//            session.setStatusSuperior(is_superior);
//
//           // Toast.makeText(getApplicationContext(), "updatestatusSuperior", Toast.LENGTH_LONG).show();
//
//        }
//    }
}
