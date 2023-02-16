package com.example.mobilebank.presentation.checkSms

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mobilebank.presentation.theme.checkSmsColorGrey
import com.example.mobilebank.presentation.theme.checkSms_19sp
import com.example.mobilebank.presentation.theme.primaryColor
import com.example.mobilebank.presentation.theme.redColor
import com.example.mobilebank.presentation.utils.BackTopBar
import com.example.mobilebank.presentation.utils.OtpTextField
import com.example.mobilebank.presentation.utils.PrimaryButton
import kotlinx.coroutines.delay

//class CheckSmsScreen : AndroidScreen() {
//
//    @Composable
//    override fun Content() {
//        CheckSmsScreen()
//    }

@SuppressLint("NotConstructor")
@Composable
fun CheckSmsScreen(phone: String, wrongCodeState: Boolean = false) {
    val code = remember { mutableStateOf("") }

    BackTopBar(text = "Verification", onClick = { }) {
        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly) {
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "Code sent to \n $phone",
                    fontSize = checkSms_19sp,
                    color = checkSmsColorGrey
                )
                OtpTextField(otpText = code.value, onOtpTextChange = { it, state ->
                    code.value = it
                })
                OtpTimer(wrongCodeState = wrongCodeState, sendAgainOnClick = {

                })
            }
            PrimaryButton(text = "Check") {

            }
        }
    }
}

@Composable
fun OtpTimer(wrongCodeState: Boolean = false, sendAgainOnClick: () -> Unit) {
    var timeLeft by remember { mutableStateOf(119) }
    LaunchedEffect(Unit) {
        while (timeLeft > 0) {
            delay(1000)
            timeLeft -= 1
        }
    }
    if (!wrongCodeState && timeLeft == 0) {
        Text(
            text = "Send Again",
            color = primaryColor,
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .padding(16.dp)
                .clickable { sendAgainOnClick() }
        )
    } else if (wrongCodeState) {
        Text(
            text = "Please try again with a password error!",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(16.dp),
            color = redColor
        )

    } else {
        Text(
            text = "Time left: ${timeLeft / 60}:${timeLeft % 60}",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(16.dp)
        )
    }
}

//}