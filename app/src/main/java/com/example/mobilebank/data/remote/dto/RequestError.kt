package com.example.mobilebank.data.remote.dto

data class RequestError(
    val errors: Errors, val message: String
)