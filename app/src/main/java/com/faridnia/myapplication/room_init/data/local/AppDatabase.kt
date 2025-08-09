package com.faridnia.myapplication.room_init.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.faridnia.myapplication.room_init.data.User


@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}