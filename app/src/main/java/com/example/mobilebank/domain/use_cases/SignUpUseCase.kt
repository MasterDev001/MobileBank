package com.example.mobilebank.domain.use_cases

import com.example.mobilebank.commons.Resource
import com.example.mobilebank.data.remote.dto.SignUpDto
import com.example.mobilebank.data.remote.dto.toVerifyModel
import com.example.mobilebank.domain.model.SignUpModel
import com.example.mobilebank.domain.model.VerifyModel
import com.example.mobilebank.domain.model.toSignUpDto
import com.example.mobilebank.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SignUpUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(signUpModel: SignUpModel): VerifyModel {
        return repository.signUp(signUpModel.toSignUpDto()).toVerifyModel()
    }
}