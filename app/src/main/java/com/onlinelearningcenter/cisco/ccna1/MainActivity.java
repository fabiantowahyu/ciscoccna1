package com.onlinelearningcenter.cisco.ccna1;

import com.onlinelearningcenter.cisco.ccna1.Adapter.ArticleAdapter;
import com.onlinelearningcenter.cisco.R;
import com.onlinelearningcenter.cisco.ccna1.Rest.RestApi;
import com.onlinelearningcenter.cisco.ccna1.config.SpiritConfig;
import com.onlinelearningcenter.cisco.ccna1.helper.InternetConnection;
import com.onlinelearningcenter.cisco.ccna1.helper.SessionManager;
import com.onlinelearningcenter.cisco.ccna1.pojo.GoalResponses;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{
    // Remove the below line after defining your own ad unit ID.
    private static final String TOAST_TEXT = "Test ads are being shown. "
            + "To show live ads, replace the ad unit ID in res/values/strings.xml with your own ad unit ID.";

    private static final int START_LEVEL = 1;
    private int mLevel;
    private Button mNextLevelButton;
    private InterstitialAd mInterstitialAd;
    private TextView infoContent;
    private String info_content,language;
    private ArrayList<GoalResponses> data;
    private ImageView btn_information,flag_indonesia,flag_usa,main_logo_toolbar;
    private RecyclerView recyclerView , recyclerView2;
    LinearLayout layout_empty;
    private SessionManager session;
    public View parentView;
    int i=0;
    private boolean started = false;
    private Handler handler = new Handler();

    final Context c = this;

    SwipeRefreshLayout swipeLayout;

    private ArticleAdapter adapterrecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       toolbar.setTitle(R.string.app_name_title);
        setSupportActionBar(toolbar);

        session = new SessionManager(getApplicationContext());

            HashMap<String, String> user = session.getUserDetails();
            info_content = user.get(SessionManager.KEY_INFORMATION);
            language = user.get(SessionManager.KEY_LANGUAGE);


        infoContent = (TextView) findViewById(R.id.infoContent);

        flag_indonesia = (ImageView) findViewById(R.id.flag_indonesia);
        flag_usa = (ImageView) findViewById(R.id.flag_usa);



//       main_logo_toolbar = (ImageView) findViewById(R.id.main_logo_toolbar);

//        if(language.equals("usa")) {
//            main_logo_toolbar.setImageDrawable(getResources().getDrawable(R.drawable.logo_lk));
//        }else{
//            main_logo_toolbar.setImageDrawable(getResources().getDrawable(R.drawable.logo_bk));
//        }

        btn_information = (ImageView) findViewById(R.id.btn_information);


        mInterstitialAd = newInterstitialAd();
        loadInterstitial();

        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);


        btn_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.information_dialog, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

                final TextView infoContent = (TextView) mView.findViewById(R.id.infoContent);


                infoContent.setText(info_content);


                alertDialogBuilderUserInput
                        .setCancelable(true)


                        .setNegativeButton("Tutup",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        dialogBox.cancel();
                                    }
                                });

                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.show();

            }
        });

        flag_indonesia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                session.setLanguage("indonesia");
               // main_logo_toolbar.setImageDrawable(getResources().getDrawable(R.drawable.logo_bk));
                language="indonesia";
                getGoalData(language);
            }
        });

        flag_usa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.setLanguage("usa");
                language="usa";
              //  main_logo_toolbar.setImageDrawable(getResources().getDrawable(R.drawable.logo_lk));
                getGoalData(language);

            }
        });



        parentView = findViewById(R.id.activity_goal);
        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view_goal);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        // RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        swipeLayout = (SwipeRefreshLayout)findViewById(R.id.swipegoal);
        swipeLayout.setOnRefreshListener(this);
        layout_empty = (LinearLayout) findViewById(R.id.emptyElementGoal);


      //  ImageView main_logo = (ImageView) findViewById(R.id.main_logo_toolbar);
      //  main_logo.setVisibility(View.VISIBLE);


//        recyclerView2 = (RecyclerView) findViewById(R.id.card_recycler_view_goal_home);
//        recyclerView2.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
//        recyclerView2.addItemDecoration(new LinePagerIndicatorDecoration());

        getGoalData(language);
//        getInformationData();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private InterstitialAd newInterstitialAd() {
        InterstitialAd interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
//                mNextLevelButton.setEnabled(true);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
//                mNextLevelButton.setEnabled(true);
                Log.d("ADMOB_ERROR_CODE", "admob error code: " + errorCode);
Toast.makeText(MainActivity.this, errorCode, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdClosed() {
                // Proceed to the next level.
                goToNextLevel();
            }
        });
        return interstitialAd;
    }

    private void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and reload the ad.
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            //Toast.makeText(this, "Ad did not load", Toast.LENGTH_SHORT).show();
//            goToNextLevel();
        }
    }

    private void loadInterstitial() {
        // Disable the next level button and load the ad.
//        mNextLevelButton.setEnabled(false);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        mInterstitialAd.loadAd(adRequest);
    }

    private void goToNextLevel() {
        // Show the next level and reload the ad to prepare for the level after.
       // mLevelTextView.setText("Level " + (++mLevel));
        mInterstitialAd = newInterstitialAd();
        loadInterstitial();
    }

    private void getGoalData(String language) {
        if (InternetConnection.checkConnection(getApplicationContext())) {


            final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this,
                    R.style.AppTheme_Dark_Dialog);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Please Wait...");
            progressDialog.show();

            RestApi api = SpiritConfig.getInterfaceService();
            Call<GoalResponses.GoalList> call = api.get_article(language);
            call.enqueue(new Callback<GoalResponses.GoalList>() {
                @Override
                public void onResponse(Call<GoalResponses.GoalList> call, Response<GoalResponses.GoalList> response) {

                    GoalResponses.GoalList totalGoalList = response.body();
                    data = new ArrayList<>(Arrays.asList(totalGoalList.getGoal()));
                    adapterrecycler = new ArticleAdapter(MainActivity.this, data, "subordinate");
                    recyclerView.setAdapter(adapterrecycler);

                    if (data.isEmpty()) {
                        layout_empty.setVisibility(View.VISIBLE);
                    }else{
                        layout_empty.setVisibility(View.GONE);
                    }

                    progressDialog.dismiss();
                }

                @Override
                public void onFailure(Call<GoalResponses.GoalList> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), R.string.string_check_internet, Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), R.string.string_internet_connection_not_available, Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onRefresh() {
        showInterstitial();
        getGoalData(language);
        swipeLayout.setRefreshing(false);
    }

//
//    private void getInformationData() {
//        if (InternetConnection.checkConnection(getApplicationContext())) {
//
//
////            final ProgressDialog progressDialog = new ProgressDialog(GoalActivity.this,
////                    R.style.AppTheme_Dark_Dialog);
////            progressDialog.setIndeterminate(true);
////            progressDialog.setMessage("Please Wait...");
////            progressDialog.show();
//
//            RestApi api = SpiritConfig.getInterfaceService();
//            Call<InformationSliderResponses.InformationSliderList> call = api.get_information();
//            call.enqueue(new Callback<InformationSliderResponses.InformationSliderList>() {
//                @Override
//                public void onResponse(Call<InformationSliderResponses.InformationSliderList> call, Response<InformationSliderResponses.InformationSliderList> response) {
//
//                    InformationSliderResponses.InformationSliderList totalInformationSliderList = response.body();
//                    data2 = new ArrayList<>(Arrays.asList(totalInformationSliderList.getInformationSlider()));
//                    adapterrecycler2 = new InformationSliderAdapter(getApplicationContext(), data2);
//                    recyclerView2.setAdapter(adapterrecycler2);
//
//                    new LinearSnapHelper().attachToRecyclerView(recyclerView2);
//
//
//                    recyclerView2.scrollToPosition(2);
////                    if (data.isEmpty()) {
////                        layout_empty.setVisibility(View.VISIBLE);
////                    }else{
////                        layout_empty.setVisibility(View.GONE);
////                    }
//
//                    // progressDialog.dismiss();
//                }
//
//
//
//                @Override
//                public void onFailure(Call<InformationSliderResponses.InformationSliderList> call, Throwable t) {
//                    Toast.makeText(getApplicationContext(), R.string.string_check_internet, Toast.LENGTH_LONG).show();
//                    //progressDialog.dismiss();
//                }
//            });
//        } else {
//            Toast.makeText(getApplicationContext(), R.string.string_internet_connection_not_available, Toast.LENGTH_LONG).show();
//        }
//
//    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {

            if(i==5){
                i=0;
            }

            recyclerView.smoothScrollToPosition(i);
            //i = recyclerView.getAdapter();
            //Toast.makeText(getActivity(), String.valueOf(i), Toast.LENGTH_SHORT).show();
            i++;


            if(started) {
                start();
            }
        }
    };



    public void start() {
        started = true;
        handler.postDelayed(runnable, 8000);
    }

    public static void setStatusBarColor(Activity activity) {
        int statusBarColor = Color.parseColor("#015F85");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // If both system bars are black, we can remove these from our layout,
            // removing or shrinking the SurfaceFlinger overlay required for our views.
            Window window = activity.getWindow();
            if (statusBarColor == Color.BLACK && window.getNavigationBarColor() == Color.BLACK) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            } else {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            }
            window.setStatusBarColor(statusBarColor);
        }
    }

}
