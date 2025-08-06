package com.faridnia.myapplication.call_api

import retrofit2.http.GET


interface ApiService {

    @GET("http")
    suspend fun getUsers(): List<User>

}
