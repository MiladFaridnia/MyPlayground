package com.faridnia.myapplication.call_api

interface MyRepository {

    suspend fun getUsers(): List<User>
}
