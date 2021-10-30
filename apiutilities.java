package com.examplenishad.NewsApp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiutilities {

    private static Retrofit retrofit=null;

    public static apiInterface getapiInterface(){

        if(retrofit==null){

            retrofit=new Retrofit.Builder().
                    baseUrl(apiInterface.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit.create(apiInterface.class);
    }


}
