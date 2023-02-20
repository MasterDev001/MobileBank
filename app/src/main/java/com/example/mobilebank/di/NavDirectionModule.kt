package com.example.mobilebank.di

import com.example.mobilebank.di.directions.*
import com.example.mobilebank.di.directions.impl.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface NavDirectionModule {

@Binds
fun addCardDirections(impl:AddCardDirectionsImpl):AddCardDirections

@Binds
fun checkSmsDirections(impl:CheckSmsDirectionsImpl):CheckSmsDirections

@Binds
fun mainScreenDirections(impl:MainScreenDirectionsImpl):MainScreenDirections

@Binds
fun signInDirections(impl:SignInDirectionsImpl):SignInDirections

@Binds
fun signUpDirections(impl:SignUpDirectionsImpl):SignUpDirections

@Binds
fun transferMoneyDirections(impl:TransferMoneyDirectionsImpl):TransferMoneyDirections


}