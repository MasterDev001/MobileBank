package com.example.mobilebank.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("password") val password: String,
    @SerializedName("phone_number") val phone: String
)