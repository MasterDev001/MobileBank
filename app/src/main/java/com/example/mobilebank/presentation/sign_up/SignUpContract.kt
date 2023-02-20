package com.example.mobilebank.presentation.sign_up

import com.example.mobilebank.domain.model.SignUpModel
import kotlinx.coroutines.flow.StateFlow

interface SignUpContract {

    interface ViewModel {
        val uiState: StateFlow<UiState>
        fun dispatcher(intent: Intent)
    }

    sealed interface Intent {
        class ToSmsCheck(val signUpModel: SignUpModel) : Intent
        object ToSignIn : Intent
    }

    sealed interface UiState {
        object Progress : UiState
        object Default : UiState
        class Error(val message: String) : UiState
    }
}