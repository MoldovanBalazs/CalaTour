package com.android.moldovanbalazs.calatour;

import android.app.Application;

import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Driver extends Application {

    private Retrofit retrofit;
    private String token;
    private String id;
    private String display;

    private final String BASE_URL = "https://cgisdev.utcluj.ro"; //https://cgisdev.utcluj.ro/moodle/chat-piu/

    public Retrofit getRetrofit() {
        if(retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

            retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .client(client)
                        .build();

        }
        return retrofit;
    }
}
