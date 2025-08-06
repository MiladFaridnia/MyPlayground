package com.faridnia.myapplication.retrofit_init_singleton

import retrofit2.Retrofit

object RetrofitClient {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
//        .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun <T> createService(serviceClass: Class<T>): T = retrofit.create(serviceClass)
}