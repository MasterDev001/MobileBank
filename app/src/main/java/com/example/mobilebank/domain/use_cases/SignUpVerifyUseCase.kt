package com.example.mobilebank.domain.use_cases

import com.example.mobilebank.domain.model.VerifyModel
import com.example.mobilebank.domain.model.toVerifyDto
import com.example.mobilebank.domain.repository.Repository
import javax.inject.Inject

class SignUpVerifyUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(verifyModel: VerifyModel): String {
        return repository.signUpVerify(verifyModel.toVerifyDto())
    }
}