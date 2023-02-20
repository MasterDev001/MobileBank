package com.example.mobilebank.data.remote.dto

data class CreateCardDto(
    val amount: String,
    val expire_month: Int,
    val expire_year: Int,
    val name: String,
    val owner: String,
    val pan: String,
    val phone_number: String
)