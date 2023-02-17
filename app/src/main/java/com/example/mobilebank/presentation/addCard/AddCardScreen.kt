package com.example.mobilebank.presentation.addCard

import LastDateTransFormation
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.core.text.isDigitsOnly
import cafe.adriel.voyager.androidx.AndroidScreen
import com.example.mobilebank.presentation.utils.AppTextFieldAddCard
import com.example.mobilebank.presentation.utils.BackTopBar
import com.example.mobilebank.presentation.utils.PrimaryButton

class AddCardScreen : AndroidScreen() {

    @Composable
    override fun Content() {
//        AddCardScreenContent()
    }
}

@Composable
fun AddCardScreenContent() {
    var cardName by remember { mutableStateOf("") }
    var cardNumber by remember { mutableStateOf("") }
    var lastDate by remember { mutableStateOf("") }

    BackTopBar(
        text = "Add Card",
        fontWeight = FontWeight.Bold,
        onClick = {
            //back button onClick
        }) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppTextFieldAddCard(text = cardName,
                    label = "Card Name",
                    placeHolder = "Name",
                    onValueChange = { cardName = it })
                AppTextFieldAddCard(
                    text = cardNumber,
                    keyboardType = KeyboardType.Number,
                    label = "Card Number",
                    placeHolder = "0000 0000 0000 0000",
                    onValueChange = { cardNumber = it })
                AppTextFieldAddCard(text = lastDate,
                    label = "Expired date",
                    keyboardType = KeyboardType.Number,
                    visualTransformation = LastDateTransFormation(),
                    placeHolder = "01/24",
                    onValueChange = { lastDate = it })
            }
            PrimaryButton(text = "Add", onClick = {

            })
        }
    }
}
