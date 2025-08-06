package com.faridnia.myapplication.room_init

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getUsers() : Flow<List<User>>

}