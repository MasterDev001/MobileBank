package com.example.mobilebank.domain.repository

import com.example.mobilebank.data.remote.dto.*
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun signUp(user: SignUpDto): VerifyDto
    suspend fun signIn(signIn: SignInDto): String
    suspend fun signUpVerify(verifyDto: VerifyDto): String
    suspend fun signUpResend(token: String): String

    suspend fun addCard(addCardDto: AddCardDto):String
    suspend fun createCard(createCardDto: CreateCardDto):String
    suspend fun transfer(verifyDto: VerifyDto):String
    suspend fun getCardsAll(verifyDto: VerifyDto):List<GetCardsAllDto>

}