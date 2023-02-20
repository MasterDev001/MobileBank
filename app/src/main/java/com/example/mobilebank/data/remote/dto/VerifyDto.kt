package com.example.mobilebank.data.remote.dto

import com.example.mobilebank.domain.model.VerifyModel

data class VerifyDto(
    val token: String,
    val code: String
)
fun VerifyDto.toVerifyModel()=VerifyModel(token, code)