package com.faridnia.myapplication.room_init.domain

import com.faridnia.myapplication.room_init.data.User
import com.faridnia.myapplication.room_init.data.local.UserDao
import com.faridnia.myapplication.room_init.data.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userDao: UserDao) : UserRepository {

    override fun getAllUsers(): Flow<List<User>> {
        return userDao.getAllUsers()
    }

    override suspend fun addUser(user: User) = userDao.insertUser(user)

    override suspend fun deleteUser(user: User) = userDao.deleteUser(user)

}