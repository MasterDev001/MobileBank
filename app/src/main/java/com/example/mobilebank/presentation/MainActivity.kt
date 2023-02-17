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
import com.example.mobilebank.commons.CODE_IS_RIGHT
import com.example.mobilebank.commons.CODE_IS_WRONG
import com.example.mobilebank.presentation.addCard.AddCardScreen
import com.example.mobilebank.presentation.addCard.AddCardScreenContent
import com.example.mobilebank.presentation.checkSms.CheckSmsScreen
import com.example.mobilebank.presentation.mainScreen.MainScreenContent
import com.example.mobilebank.presentation.theme.*
import com.example.mobilebank.presentation.utils.BackTopBar
import com.example.mobilebank.presentation.utils.OtpTextField
import com.example.mobilebank.presentation.utils.PasswordTextField
import com.example.mobilebank.presentation.utils.PrimaryButton
import com.example.mobilebank.ui.theme.MobileBankTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankAppTheme {
                // A surface container using the 'background' color from the theme

                Column(Modifier.fillMaxSize()) {
                    val text = remember { mutableStateOf("") }
                    val code = remember { mutableStateOf(0) }

                    AddCardScreenContent()
//                    MainScreenContent {
//
//                    }
//                    CheckSmsScreen(phone = text.value)
//                    OtpTextField(
//                        otpText = text.value,
//                        codeCheck = code.value,
//                        onOtpTextChange = { it, i ->
//                            text.value = it
//                        })
//                    Button(onClick = { code.value = CODE_IS_RIGHT }) {
//                        Text(text = "jaiosdhgiuohas")
//                    }
//                    Button(onClick = { code.value = CODE_IS_WRONG }) {
//                        Text(text = "jaiosdhgiuohas")
//                    }

                }

//                PasswordTextField(text = text.value, hint = "jga", onValueChange ={text.value=it} )
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