package com.example.mobilebank.di.directions

interface MainScreenDirections {

    suspend fun toAddCardScreen()

    suspend fun toTransferMoneyScreen()
}