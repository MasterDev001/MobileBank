package com.example.mobilebank.di.directions.impl

import com.example.mobilebank.di.directions.SignUpDirections
import com.example.mobilebank.di.navigation.AppNavigator
import com.example.mobilebank.domain.model.SignUpModel
import com.example.mobilebank.presentation.check_sms.CheckSmsScreen
import com.example.mobilebank.presentation.sign_in.SignInScreen
import javax.inject.Inject

class SignUpDirectionsImpl @Inject constructor(private val appNavigator: AppNavigator) :
    SignUpDirections {

    override suspend fun toCheckSmsScreen(phone:String) {
        appNavigator.navigateTo(CheckSmsScreen(phone))
    }

    override suspend fun toSignInScreen() {
        appNavigator.navigateTo(SignInScreen())
    }
}