package com.faridnia.myapplication.room_init

import androidx.room.Entity


@Entity(tableName = "users")
data class User(val name : String, val createDate : String)
