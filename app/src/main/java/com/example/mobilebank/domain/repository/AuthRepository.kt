package com.example.mobilebank.domain.repository

import com.example.mobilebank.data.model.ResponseSignUp
import com.example.mobilebank.data.model.SignIn
import com.example.mobilebank.data.model.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    suspend fun signUp(user: User): Flow<ResponseSignUp>

    suspend fun signIn(signIn: SignIn): Flow<String>
    suspend fun signVerify(token: String): Flow<String>
    suspend fun signUpResend(token: String): Flow<String>


}