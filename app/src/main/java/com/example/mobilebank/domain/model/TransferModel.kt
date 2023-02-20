package com.example.mobilebank.domain.model

data class TransferModel(
    val amount: Int,
    val from_card_id: Int,
    val pan: String
)