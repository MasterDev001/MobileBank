package com.example.mobilebank.di.directions.impl

import com.example.mobilebank.di.directions.CheckSmsDirections
import com.example.mobilebank.di.navigation.AppNavigator
import com.example.mobilebank.presentation.main_screen.MainScreen
import javax.inject.Inject

class CheckSmsDirectionsImpl @Inject constructor(private val appNavigator: AppNavigator) :
    CheckSmsDirections {
    override suspend fun toMainScreen() {
        appNavigator.navigateTo(MainScreen())
    }
}