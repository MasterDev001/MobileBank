package com.example.mobilebank.domain.model

import com.example.mobilebank.data.remote.dto.SignUpDto

data class SignUpModel(
    var firstName: String,
    var lastName: String,
    var password: String,
    var phone: String
)
fun SignUpModel.toSignUpDto()=SignUpDto(firstName, lastName, phone, password)