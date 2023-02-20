package com.example.mobilebank.di.navigation

interface AppNavigator {
    suspend fun back()
    suspend fun navigateTo(screen: AppScreen)
    suspend fun navigateTo(screens: List<AppScreen>)
    suspend fun replaceAll(screen: AppScreen)
    suspend fun <T : AppScreen> backUntil(clazz: Class<T>)
}