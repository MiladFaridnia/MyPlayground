package com.faridnia.myapplication.call_api

sealed class Response {
    object Loading : Response()
    data class Success(val data: List<User>) : Response()
    data class Error(val message: String) : Response()
}
