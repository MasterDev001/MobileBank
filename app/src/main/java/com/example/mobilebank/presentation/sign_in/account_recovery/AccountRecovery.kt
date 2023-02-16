package com.example.mobilebank.presentation.sign_in.account_recovery

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import com.example.mobilebank.presentation.signUp.AppTextField
import com.example.mobilebank.presentation.utils.PrimaryButton
import com.example.mobilebank.ui.theme.MobileBankTheme

class AccountRecovery : AndroidScreen() {
    @Composable
    override fun Content() {
    }
}

@Composable
fun AccountRecoveryContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Account recovery",
            color = Color.Black,
            style = MaterialTheme.typography.h4,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Column {
            Text(
                text = "To get a verification code," + " first confirm the recovery phone number",
                color = Color.Black,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(bottom = 40.dp)
            )

            AppTextField(hint = "Phone number", onValueChange = {})
        }


        PrimaryButton(text = "Send") {}
    }
}

@Preview
@Composable
fun AccountRecoveryContentPreview() {
    MobileBankTheme() {
        AccountRecoveryContent()
    }
}