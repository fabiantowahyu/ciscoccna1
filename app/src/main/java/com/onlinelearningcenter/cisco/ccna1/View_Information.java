package com.onlinelearningcenter.cisco.ccna1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.onlinelearningcenter.cisco.R;
import com.onlinelearningcenter.cisco.ccna1.helper.SessionManager;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.HashMap;


public class View_Information extends ActionBarActivity {
    private WebView view; //membuat variabel view agar bisa akses method onKeyDown
    public String url,link,title,language,new_url;
    SessionManager session;
    private InterstitialAd mInterstitialAd;
    public ProgressDialog progressDialog;
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MainActivity.setStatusBarColor(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_webview);


                progressDialog = new ProgressDialog(View_Information.this,R.style.AppTheme_Dark_Dialog);
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();


                Intent intent = getIntent();
       link = intent.getStringExtra("link");
        title = intent.getStringExtra("title");

        AdView adView_webview = (AdView) findViewById(R.id.adView_webview);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView_webview.loadAd(adRequest);

        session = new SessionManager(getApplicationContext());

        HashMap<String, String> user = session.getUserDetails();
        language = user.get(SessionManager.KEY_LANGUAGE);


        new_url = link+"/"+language;

        url =   String.format(new_url);



        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                if(progressDialog!=null && progressDialog.isShowing())
                {
                    progressDialog.dismiss();
                    showInterstitial();
                }
            }
        });
        mWebView.loadUrl(url);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_webview);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                finish();
            }
        });

        mInterstitialAd = newInterstitialAd();
        loadInterstitial();

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
//            Toast.makeText(this, "Ad did not load", Toast.LENGTH_SHORT).show();
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






//        view = (WebView) this.findViewById(R.id.webView);
//        view.getSettings().setJavaScriptEnabled(true);
//        view.setWebViewClient(new MyBrowser());
//        // register class containing methods to be exposed to JavaScript
//        view.addJavascriptInterface(new WebAppInterface(this), "Android");

//
//





    }

//    private class MyBrowser extends WebViewClient {
//
//
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            view.loadUrl(url);
//
//            return true;
//        }
//
//        @Override
//        public void onPageFinished(WebView view, String url) {
//
//
//            // TODO Auto-generated method stub
//
//            super.onPageFinished(view, url);
//
//            //Toast.makeText(getApplication(), R.string.string_check_internet, Toast.LENGTH_LONG).show();
//            if(progressDialog!=null && progressDialog.isShowing())
//            {
//                progressDialog.dismiss();
//            }
////            progressDialog.dismiss();
//
//        }
//
//    }
//
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        //ketika disentuh tombol back
//        if ((keyCode == KeyEvent.KEYCODE_BACK) && view.canGoBack()) {
//            //view.goBack(); //method goback() dieksekusi untuk kembali pada halaman sebelumnya
//            setResult(Activity.RESULT_OK);
//            finish();
//            return true;
//        }
//        // Jika tidak ada history (Halaman yang sebelumnya dibuka)
//        // maka akan keluar dari activity
//        return super.onKeyDown(keyCode, event);
//    }
//
//    public class WebAppInterface {
//        Context mContext;
//
//        /** Instantiate the interface and set the context */
//        WebAppInterface(Context c) {
//            mContext = c;
//        }
//
//        /** Show a toast from the web page */
//        @JavascriptInterface
//        public void finishActivity(String toast, String status) {
//            if(status.equals("success")) {
//                Toast.makeText(mContext, toast, Toast.LENGTH_LONG).show();
//                finish();
//            }else{
//                Toast.makeText(mContext, toast, Toast.LENGTH_LONG).show();
//            }
//        }
//    }
//
//}
