package com.example.mobilebank.di.directions.impl

import com.example.mobilebank.di.directions.AddCardDirections
import com.example.mobilebank.di.navigation.AppNavigator
import javax.inject.Inject


class AddCardDirectionsImpl @Inject constructor(private val appNavigator: AppNavigator) :
    AddCardDirections {

    override suspend fun backToMainScreen() {
        appNavigator.back()
    }
}