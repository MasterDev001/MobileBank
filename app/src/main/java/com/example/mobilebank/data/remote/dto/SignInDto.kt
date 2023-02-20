package com.example.mobilebank.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SignInDto(
    @SerializedName("phone_number") val phone: String,
    @SerializedName("password") val password: String
)
