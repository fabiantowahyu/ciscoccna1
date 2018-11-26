package com.onlinelearningcenter.cisco.ccna1.config;

import com.onlinelearningcenter.cisco.ccna1.Rest.RestApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by danang on 11/30/2016.
 */

public class SpiritConfig {

    public static String API_URL;

    static{
        //API_URL = "http://117.54.138.70/api_360pa/index.php/api/v1/"; //live server
        //API_URL = "http://10.0.3.2/api_360pa/index.php/api/v1/"; //localhost geny
        API_URL = "http://belajar-komputer.online/api_belajar/index.php/api/v1_1_ccna_1/"; //untuk AVD
    }

    public static RestApi getInterfaceService() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

// set log level
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

//add logging
        okHttpClient.addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RestApi mInterfaceService = retrofit.create(RestApi.class);
        return mInterfaceService;
    }
}
