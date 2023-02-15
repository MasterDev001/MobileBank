package com.example.mobilebank.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobilebank.presentation.theme.*
import com.example.mobilebank.presentation.utils.PasswordTextField
import com.example.mobilebank.presentation.utils.PrimaryButton
import com.example.mobilebank.ui.theme.MobileBankTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankAppTheme {
                // A surface container using the 'background' color from the theme
                val password = remember { mutableStateOf("") }
                PasswordTextField(
                    text = password.value,
                    hint = "Password",
                    onValueChange = { password.value = it })
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    BankAppTheme {
////        Greeting("Android")
//        PrimaryButton(text = "hgadshg") {
//
//        }
//
//    }
//}