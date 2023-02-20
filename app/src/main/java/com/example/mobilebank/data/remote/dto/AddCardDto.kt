package com.example.mobilebank.data.remote.dto

data class AddCardDto(
    val expire_month: Int,
    val expire_year: Int,
    val name: String,
    val pan: String
)