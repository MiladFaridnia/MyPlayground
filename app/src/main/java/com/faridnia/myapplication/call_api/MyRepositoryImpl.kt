package com.faridnia.myapplication.call_api


class MyRepositoryImpl(val apiService: ApiService) : MyRepository {

    override fun getUsers(): Response<List<User>>{
        return apiService.getUsers()

    }

}