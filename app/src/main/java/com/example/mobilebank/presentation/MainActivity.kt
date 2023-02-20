package com.example.mobilebank.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.example.mobilebank.di.navigation.AppNavigationHandler
import com.example.mobilebank.presentation.sign_up.SignUpScreen
import com.example.mobilebank.presentation.theme.*
import com.example.mobilebank.ui.theme.MobileBankTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationHandler: AppNavigationHandler

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileBankTheme {
                    Navigator(SignUpScreen()) { navigator ->
                        LaunchedEffect(key1 = navigator) {
                            navigationHandler.navigation
                                .onEach { it(navigator) }
                                .collect()
                        }
                        CurrentScreen()
                }
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