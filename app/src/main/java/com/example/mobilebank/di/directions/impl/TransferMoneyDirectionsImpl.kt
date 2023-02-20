package com.example.mobilebank.di.directions.impl

import com.example.mobilebank.di.directions.TransferMoneyDirections
import com.example.mobilebank.di.navigation.AppNavigator
import javax.inject.Inject

class TransferMoneyDirectionsImpl @Inject constructor(private val appNavigator: AppNavigator) :
    TransferMoneyDirections {

    override suspend fun backToMainScreen() {
//
    }
}