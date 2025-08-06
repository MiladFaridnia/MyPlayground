package com.faridnia.myapplication.call_api

import retrofit2.Retrofit

object RetrofitProvider {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
//        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val apiService : ApiService = retrofit.create(ApiService::class.java)

}