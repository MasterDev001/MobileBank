package com.example.mobilebank.presentation.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun AppTextField(
    hint: String,
    testTag: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    textStyle: TextStyle = TextStyle(),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit
) {
    var name by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = name,
        onValueChange = { name = it },
        label = { Text(text = hint) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
            .testTag(testTag),
        shape = RoundedCornerShape(CornerSize(12.dp)),
        textStyle = textStyle,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Gray, unfocusedLabelColor = Color.Black
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = visualTransformation
    )
}