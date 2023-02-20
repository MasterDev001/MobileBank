package com.example.mobilebank.di.directions.impl

import com.example.mobilebank.di.directions.SignInDirections
import com.example.mobilebank.di.navigation.AppNavigator
import com.example.mobilebank.presentation.check_sms.CheckSmsScreen
import javax.inject.Inject

class SignInDirectionsImpl @Inject constructor(private val appNavigator: AppNavigator) :
    SignInDirections {
//    override suspend fun toCheckSmsScreen() {
////        appNavigator.navigateTo(CheckSmsScreen())
//    }
}