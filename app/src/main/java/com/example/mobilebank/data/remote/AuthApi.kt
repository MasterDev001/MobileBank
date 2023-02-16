package com.example.mobilebank.data.remote

import com.example.mobilebank.data.model.ResponseSignUp
import com.example.mobilebank.data.model.SignIn
import com.example.mobilebank.data.model.User
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("/auth/sign-up")
    suspend fun signUp(@Body user: User): Flow<ResponseSignUp>

    @POST("/auth/sign-in")
    suspend fun signIn(@Body signIn: SignIn): Flow<String>

    @POST("/auth/sign-up/verify")
    suspend fun signUpVerify(@Body token: String): Flow<String>

    @POST("/auth/sign-up/resend")
    suspend fun signUpResend(@Body token: String): Flow<String>

}