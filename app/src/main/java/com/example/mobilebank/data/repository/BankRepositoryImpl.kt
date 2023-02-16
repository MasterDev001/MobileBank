package com.example.mobilebank.data.repository

import com.example.mobilebank.data.model.ResponseSignUp
import com.example.mobilebank.data.model.SignIn
import com.example.mobilebank.data.model.User
import com.example.mobilebank.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BankRepositoryImpl @Inject constructor([p;]) : AuthRepository {
    override suspend fun signUp(user: User): Flow<ResponseSignUp> = flow {

    }

    override suspend fun signIn(signIn: SignIn): Flow<String> {
        TODO("Not yet implemented")
    }

    override suspend fun signVerify(token: String): Flow<String> {
        TODO("Not yet implemented")
    }

    override suspend fun signUpResend(token: String): Flow<String> {
        TODO("Not yet implemented")
    }

}