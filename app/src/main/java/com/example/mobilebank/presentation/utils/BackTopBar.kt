package com.example.mobilebank.presentation.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.mobilebank.R
import com.example.mobilebank.presentation.theme.horizontalPadding_16


@Composable
fun BackTopBar(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 20.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    style: TextStyle = TextStyle.Default,
    onClick: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier.padding(start = horizontalPadding_16),
        topBar = {
            TopAppBar(
                title = {
                    Box(Modifier.fillMaxWidth(),Alignment.Center) {
                        Text(
                            text = text,
                            fontSize = fontSize,
                            style = style,
                            fontWeight=fontWeight
                        )
                    }
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "",
                        modifier = Modifier
                            .clickable { onClick() })
                }
            )
        }, content = content
    )

}