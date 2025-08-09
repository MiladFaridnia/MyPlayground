package com.faridnia.myapplication.room_init.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faridnia.myapplication.room_init.domain.UserRepositoryImpl
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val userRepository: UserRepositoryImpl
) : ViewModel() {

    val users = userRepository.getAllUsers()

    init {
        getAllUsers()
    }

    private fun getAllUsers() {
        userRepository.getAllUsers()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Companion.WhileSubscribed(1000),
                initialValue = emptyList()
            )

    }

}