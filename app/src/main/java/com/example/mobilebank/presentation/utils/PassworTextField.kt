package com.example.mobilebank.presentation.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.mobilebank.R

@Composable
fun PasswordTextField(
    text:String,
    hint: String,
    testTag: String = "",
    textStyle: TextStyle = TextStyle(),
    onValueChange: (String) -> Unit
) {
    val password by rememberSaveable { mutableStateOf(text.isEmpty()) }
    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility) {
        painterResource(id = R.drawable.eye)
    } else {
        painterResource(id = R.drawable.eye_close)
    }

    OutlinedTextField(
        value = text,
        onValueChange =onValueChange,
        label = { Text(text = hint) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
            .testTag(testTag),
        shape = RoundedCornerShape(CornerSize(12.dp)),
        textStyle = textStyle,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Gray, unfocusedLabelColor = Color.Black,
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        placeholder = { Text(text = "Password") },
        trailingIcon = {
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
            Icon(painter = icon, contentDescription = "")
            }
        }
    )
}