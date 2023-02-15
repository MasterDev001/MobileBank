package com.example.mobilebank.presentation.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.mobilebank.R
import com.example.mobilebank.presentation.theme.horizontalPadding_21


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackTopBar(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 20.sp,
    style: TextStyle = TextStyle.Default,
    onClick: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier.padding(start = horizontalPadding_21),
        topBar = {
            TopAppBar(
                title = {
                    Box(Modifier.fillMaxWidth(),Alignment.Center) {
                        Text(
                            text = text,
                            fontSize = fontSize,
                            style = style,
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