package com.example.mobilebank.presentation.utils


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.mobilebank.presentation.theme.*

@Composable
fun PrimaryButton(text: String , onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .padding(horizontal = horizontalPadding_16)
            .fillMaxWidth()
            .height(primaryButtonHeight),
        shape = RoundedCornerShape(primaryCornerRadius_16),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = primaryColor,
            contentColor = onPrimaryColor
        )
    ) {
        Text(text = text, fontSize = textSize_21sp)
    }
}