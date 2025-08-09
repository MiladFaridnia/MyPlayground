package com.faridnia.myapplication.room_init.data.repository

import com.faridnia.myapplication.room_init.data.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getAllUsers(): Flow<List<User>>
    suspend fun addUser(user: User)
    suspend fun deleteUser(user: User)
}