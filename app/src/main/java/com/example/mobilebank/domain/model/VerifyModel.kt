package com.example.mobilebank.domain.model

import com.example.mobilebank.data.remote.dto.VerifyDto

data class VerifyModel(
    val token: String,
    val code: String
)
fun VerifyModel.toVerifyDto()=VerifyDto(token, code)
