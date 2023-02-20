package com.example.mobilebank.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SignUpDto(
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("phone_number") val phone: String,
    @SerializedName("password") val password: String
)