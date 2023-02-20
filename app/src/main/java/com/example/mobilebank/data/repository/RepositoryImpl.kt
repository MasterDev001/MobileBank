package com.example.mobilebank.data.repository

import com.example.mobilebank.data.remote.AuthApi
import com.example.mobilebank.data.remote.dto.*
import com.example.mobilebank.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val api: AuthApi) : Repository {

    override suspend fun signUp(user: SignUpDto): VerifyDto{
        return api.signUp(user)
    }

    override suspend fun signIn(signIn: SignInDto): String {
        return api.signIn(signIn)
    }

    override suspend fun signUpVerify(verifyDto: VerifyDto): String {
        return api.signUpVerify(verifyDto)
    }

    override suspend fun signUpResend(token: String): String {
        return api.signUpResend(token)
    }

    override suspend fun addCard(addCardDto: AddCardDto): String {
        return api.addCard(addCardDto)
    }

    override suspend fun createCard(createCardDto: CreateCardDto): String {
        return api.createCard(createCardDto)
    }

    override suspend fun transfer(verifyDto: VerifyDto): String {
        return api.transfer(verifyDto)
    }

    override suspend fun getCardsAll(verifyDto: VerifyDto): List<GetCardsAllDto> {
        return api.getCardsAll()
    }
}