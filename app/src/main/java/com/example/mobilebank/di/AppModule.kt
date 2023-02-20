package com.example.mobilebank.di

import com.example.mobilebank.commons.BASE_URL
import com.example.mobilebank.data.remote.AuthApi
import com.example.mobilebank.data.repository.RepositoryImpl
import com.example.mobilebank.domain.model.SignUpModel
import com.example.mobilebank.domain.repository.Repository
import com.example.mobilebank.domain.use_cases.BankUseCases
import com.example.mobilebank.domain.use_cases.SignUpUseCase
import com.example.mobilebank.domain.use_cases.SignUpVerifyUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @[Provides Singleton]
    fun provideAuthApi(): AuthApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(AuthApi::class.java)
    }

    @[Provides Singleton]
    fun provideAuthRepository(authApi: AuthApi): Repository {
        return RepositoryImpl(authApi)
    }

    @[Provides Singleton]
    fun providesUseCases(repository: Repository): BankUseCases {
        return BankUseCases(
            signUpUseCase = SignUpUseCase(repository),
            signUpVerifyUseCase = SignUpVerifyUseCase(repository)
        )
    }

    @Singleton
    @Provides
    fun provideSignUpModel(): SignUpModel {
        return SignUpModel(firstName = "", lastName = "", password = "", phone = "")
    }
}