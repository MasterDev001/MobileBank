package com.example.mobilebank.data.remote.dto

data class TransferDto(
    val amount: Int,
    val from_card_id: Int,
    val pan: String
)