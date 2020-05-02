package com.demo.service

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitInstance {

    var gson : Gson? = null
   lateinit var  retrofit : Retrofit
    private val BASE_URL = "https://api.darksky.net/"


     fun setUpClient() : Retrofit {
        gson =  GsonBuilder()
                .setLenient()
                .create();

         val okHttpClient = OkHttpClient().newBuilder()
             .connectTimeout(120, TimeUnit.SECONDS)
             .readTimeout(120, TimeUnit.SECONDS)
             .writeTimeout(120, TimeUnit.SECONDS)
             .build()


        retrofit =  Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
                .build()

        return retrofit

    }
}