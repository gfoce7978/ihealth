package com.example.healthapp.Retrofit;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {
    public static Retrofit instance;

    public static Retrofit getInstance(){
        if(instance == null)
        {
              instance = new Retrofit.Builder()
                        .baseUrl("http://192.168.0.104:3000/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .addConverterFactory(ScalarsConverterFactory.create())
                         .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();
        }
        return instance;
    }

}
