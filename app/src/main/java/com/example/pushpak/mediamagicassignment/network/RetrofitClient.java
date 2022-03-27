package com.example.pushpak.mediamagicassignment.network;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Pushpak on 3/27/2022.
 */

@SuppressWarnings("deprecation")
public class RetrofitClient {

    private static RetrofitClient retrofitClient = null;


    private RetrofitClient(){

    }

    public static RetrofitClient getInstance(){
        if(retrofitClient == null)
            retrofitClient = new RetrofitClient();
        return retrofitClient;
    }

    public Retrofit getRetrofit(){
        return new Retrofit.Builder().baseUrl("www.google/").addConverterFactory(SimpleXmlConverterFactory.create()).build();
    }
}
