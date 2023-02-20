package com.example.mobilebank.data.remote

import com.example.mobilebank.data.remote.dto.*
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi {

    @POST("/auth/sign-up")
    suspend fun signUp(@Body user: SignUpDto): VerifyDto

    @POST("/auth/sign-in")
    suspend fun signIn(@Body signIn: SignInDto): String

    @POST("/auth/sign-up/verify")
    suspend fun signUpVerify(@Body verify: VerifyDto):String

    @POST("/auth/sign-up/resend")
    suspend fun signUpResend(@Body token: String): String

    @POST("/cards")
    suspend fun addCard(@Body addCard: AddCardDto): String

    @POST("/cards/create")
    suspend fun createCard(@Body createCard: CreateCardDto):String

    @POST("/transfers")
    suspend fun transfer(@Body verify: VerifyDto): String

    @GET("/all-cards")
    suspend fun getCardsAll():List<GetCardsAllDto>


}