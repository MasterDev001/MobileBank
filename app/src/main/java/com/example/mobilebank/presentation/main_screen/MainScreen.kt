package com.example.mobilebank.presentation.main_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mobilebank.R
import com.example.mobilebank.di.navigation.AppScreen
import com.example.mobilebank.domain.model.CardModel
import com.example.mobilebank.presentation.theme.*

class MainScreen : AppScreen() {

    @Composable
    override fun Content() {
        MainScreenContent(){}
    }

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreenContent(notificationsOnClick: () -> Unit) {
    var bottomState by remember { mutableStateOf("Accounts") }
    Scaffold(topBar = {
        TopAppBar(modifier = Modifier.fillMaxWidth(),
            backgroundColor = colorMainBackground,
            title = {
                Text(
                    text = "My accounts",
                    fontSize = largeTextSize_32sp,
                    style = MaterialTheme.typography.h1,
                    fontWeight = FontWeight.Bold
                )
            },
            actions = {
                IconButton(onClick = { notificationsOnClick() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.notifications),
                        contentDescription = ""
                    )
                }
            })
    }, bottomBar = {
        BottomNavigation(
            Modifier.clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
            backgroundColor = Color.White,
        ) {
            BottomNavigationItem(selected = bottomState == "Accounts",
                onClick = { bottomState = "Accounts" },
                selectedContentColor = primaryColor,
                unselectedContentColor = bottomBarTextColor,
                label = {
                    Text(text = "Accounts", fontSize = bottomBarTextSize_16)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.accounts), contentDescription = ""
                    )
                })
            BottomNavigationItem(selected = bottomState == "Statistics",
                onClick = { bottomState = "Statistics" },
                selectedContentColor = primaryColor,
                unselectedContentColor = bottomBarTextColor,
                label = {
                    Text(text = "Statistics", fontSize = bottomBarTextSize_16)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.statistics),
                        contentDescription = ""
                    )
                })
            BottomNavigationItem(selected = bottomState == "Cashback",
                onClick = { bottomState = "Cashback" },
                selectedContentColor = primaryColor,
                unselectedContentColor = bottomBarTextColor,
                label = {
                    Text(text = "Cashback", fontSize = bottomBarTextSize_16)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.cashbacks),
                        contentDescription = ""
                    )
                })
            BottomNavigationItem(selected = bottomState == "Settings",
                onClick = { bottomState = "Settings" },
                selectedContentColor = primaryColor,
                unselectedContentColor = bottomBarTextColor,
                label = {
                    Text(text = "Settings", fontSize = bottomBarTextSize_16)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.settings), contentDescription = ""
                    )
                })
        }
    }) {
        Column(
            Modifier
                .fillMaxSize()
                .background(colorMainBackground)
        ) {
            val cardList = remember { mutableStateListOf<CardModel>() }
            LaunchedEffect(key1 = true) {
                val t = CardModel("89558877", "684", "58/85")
                val r = CardModel("24554676", "45454", "5/5")
                cardList.add(t)
                cardList.add(r)
            }
            LazyRow(Modifier.fillMaxWidth()) {
                items(count = cardList.size) {
                    val card = cardList[it]
                    Card(
                        Modifier
                            .padding(horizontalPadding_16)
                            .size(312.dp, 168.dp),
                        backgroundColor = primaryColor,
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(horizontalPadding_16),
                            verticalArrangement = Arrangement.SpaceAround
                        ) {
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = "**** ${card.id.takeLast(4)}", fontSize = textSize_21sp)
                                Text(card.latestDate, fontSize = textSize_21sp)
                            }
                            Text(text = "Balance", fontSize = textSize_21sp)
                            Text(text = "$${card.balance}", fontSize = largeTextSize_32sp)
                        }
                    }
                }
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CircleMainButton(
                    text = "Add Card",
                    painter = painterResource(id = R.drawable.card),
                    onClick = {

                    })
                CircleMainButton(
                    text = "Pay",
                    painter = painterResource(id = R.drawable.pay),
                    onClick = {

                    })
                CircleMainButton(
                    text = "Send",
                    painter = painterResource(id = R.drawable.send),
                    onClick = {

                    })
                CircleMainButton(
                    text = "More",
                    painter = painterResource(id = R.drawable.more),
                    onClick = {

                    })
            }
        }
    }
}

@Composable
fun CircleMainButton(text: String, painter: Painter, onClick: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                onClick()
            }, modifier = Modifier
                .padding(12.dp)
                .size(64.dp),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White
            )
        ) {
            Icon(painter = painter, contentDescription = "")
        }
        Text(modifier = Modifier.padding(8.dp), text = text, fontSize = bottomBarTextSize_16)
    }
}
