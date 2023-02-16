package com.example.mobilebank.presentation.sign_in

import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
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
import com.example.mobilebank.presentation.utils.AppTextField
import com.example.mobilebank.presentation.utils.PasswordTextField
import com.example.mobilebank.presentation.utils.PrimaryButton
import com.example.mobilebank.ui.theme.MobileBankTheme

class SignIn : AndroidScreen() {

    @Composable
    override fun Content() {
        TODO("Not yet implemented")
    }

}


@Composable
fun SignInContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sign In", color = Color.Black, style = MaterialTheme.typography.h4
        )
        Column {
            AppTextField(hint = "Phone number", onValueChange = {})
            PasswordTextField(onValueChange = {}, hint = "Paasword")
            Text(text = "Forgot password?",
                color = Color(0xFF3862F8),
                modifier = Modifier
                    .padding(top = 5.dp)
                    .align(Alignment.Start)
                    .clickable { }
                    .focusable(true))
        }
        PrimaryButton(text = "Sign In") {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInContentPreview() {
    MobileBankTheme() {
        SignInContent()
    }
}