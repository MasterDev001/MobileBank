package com.example.mobilebank.di.directions

import com.example.mobilebank.domain.model.SignUpModel

interface SignUpDirections {

    suspend fun toCheckSmsScreen(phone:String)

    suspend fun toSignInScreen()
}