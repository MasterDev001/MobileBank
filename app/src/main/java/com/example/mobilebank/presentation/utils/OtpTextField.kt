package com.example.mobilebank.presentation.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.example.mobilebank.commons.CODE_IS_RIGHT
import com.example.mobilebank.commons.CODE_IS_WRONG
import com.example.mobilebank.presentation.theme.checkSmsFontSize
import com.example.mobilebank.presentation.theme.greenColor
import com.example.mobilebank.presentation.theme.redColor
import com.example.mobilebank.presentation.theme.textFieldBackColor
import com.example.mobilebank.ui.theme.GreyLight

@Composable
fun OtpTextField(
    otpText: String, onOtpTextChange: (String, Boolean) -> Unit, codeCheck: Int = 0
) {
    BasicTextField(
        value = otpText,
        onValueChange = {
            if (it.length <= 6 && it.isDigitsOnly()) {
                onOtpTextChange.invoke(it, it.length == 6)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        decorationBox = {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                repeat(6) { index ->
                    CharView(
                        index = index, text = otpText, codeCheck
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        })
}

@Composable
private fun CharView(
    index: Int, text: String, codeCheck: Int
) {

    val isFocused = text.length == index
    val char = when {
        index == text.length -> ""
        index > text.length -> ""
        else -> text[index].toString()
    }
    Text(
        modifier = Modifier
            .width(40.dp)
            .border(
                1.dp, when {
                    isFocused && index > 0 && codeCheck == 0 -> greenColor
                    codeCheck == CODE_IS_WRONG  -> redColor
                    codeCheck == CODE_IS_RIGHT -> greenColor
                    else -> GreyLight
                }, RoundedCornerShape(8.dp)
            )
            .padding(2.dp)
            .background(textFieldBackColor),
        text = char,
        style = MaterialTheme.typography.h4,
        fontWeight = FontWeight.Bold,
        fontSize = checkSmsFontSize,
        color = if (isFocused) {
            GreyLight
        } else {
            Color.Black
        },
        textAlign = TextAlign.Center
    )
}