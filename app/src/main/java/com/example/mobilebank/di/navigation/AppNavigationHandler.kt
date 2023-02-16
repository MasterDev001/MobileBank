package com.example.mobilebank.di.navigation

import kotlinx.coroutines.flow.Flow

interface AppNavigationHandler {
    val navigation: Flow<NavigationArgs>
}