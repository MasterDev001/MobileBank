package com.example.mobilebank.data.model

data class RequestError(
    val errors: Errors, val message: String
)