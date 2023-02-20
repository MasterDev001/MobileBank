package com.example.mobilebank.di

import android.app.Application
import com.example.mobilebank.di.navigation.AppNavigationHandler
import com.example.mobilebank.di.navigation.AppNavigator
import com.example.mobilebank.di.navigation.AppNavigatorDispatcher
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    fun navigator(dispatcher:AppNavigatorDispatcher):AppNavigator

    @Binds
    fun navigatorHandler(dispatcher: AppNavigatorDispatcher):AppNavigationHandler
}