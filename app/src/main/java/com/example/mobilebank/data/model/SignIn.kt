package com.example.mobilebank.data.model

import com.google.gson.annotations.SerializedName

data class SignIn(
    @SerializedName("password") val password: String,
    @SerializedName("phone_number") val phone: String
)
