package com.example.mobilebank.presentation.sign_up

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobilebank.di.directions.SignUpDirections
import com.example.mobilebank.domain.use_cases.BankUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModelImpl @Inject constructor(
    private val useCases: BankUseCases,
    private val signUpDirections: SignUpDirections
) : ViewModel(),SignUpContract.ViewModel{

    override val uiState = MutableStateFlow(SignUpContract.UiState.Default)


    override fun dispatcher(intent: SignUpContract.Intent) {
        when (intent) {
            is SignUpContract.Intent.ToSmsCheck -> {
                viewModelScope.launch {
                    val verify=useCases.signUpUseCase(intent.signUpModel)
                    signUpDirections.toCheckSmsScreen(intent.signUpModel.phone)
                }
            }
            is SignUpContract.Intent.ToSignIn -> {
                viewModelScope.launch {
////                    signUpDirections.toSignInScreen()
                }
            }
        }
    }
}