package com.example.mobilebank.di.directions.impl

import com.example.mobilebank.di.directions.MainScreenDirections
import com.example.mobilebank.di.navigation.AppNavigator
import com.example.mobilebank.presentation.add_card.AddCardScreen
import javax.inject.Inject

class MainScreenDirectionsImpl @Inject constructor(private val appNavigator: AppNavigator) :
    MainScreenDirections {
    override suspend fun toAddCardScreen() {
        appNavigator.navigateTo(AddCardScreen())
    }

    override suspend fun toTransferMoneyScreen() {
//
    }
}