package com.example.mobilebank.presentation.sign_up

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.hilt.getViewModel
import com.example.mobilebank.di.navigation.AppScreen
import com.example.mobilebank.domain.model.SignUpModel
import com.example.mobilebank.presentation.utils.AppTextFieldAddCard
import com.example.mobilebank.presentation.utils.PrimaryButton

class SignUpScreen : AppScreen() {

    @Composable
    override fun Content() {
        lateinit var signUpModel: SignUpModel
        val viewModel: SignUpContract.ViewModel = getViewModel<SignUpViewModelImpl>()
        val uiState = viewModel.uiState.collectAsState()
        SignUpScreenContent(uiState, signUpModel, viewModel::dispatcher)
    }

}

@Composable
fun SignUpScreenContent(
    uiState: State<SignUpContract.UiState>, signUpModel: SignUpModel,
    onDispatcher: (SignUpContract.Intent) -> Unit
) {
    val firstName = remember { mutableStateOf("") }
    val lastName = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sign Up",
            modifier = Modifier.padding(bottom = 20.dp),
            style = MaterialTheme.typography.h5
        )
        AppTextFieldAddCard(
            text = firstName.value,
            label = "First name",
            onValueChange = { firstName.value = it })
        AppTextFieldAddCard(text = lastName.value, label = "Last name", onValueChange = {})
//        AppTextFieldAddCard(text =:, label = "Date of birth", onValueChange = {})
        AppTextFieldAddCard(
            text = phone.value,
            label = "Phone number",
            onValueChange = { phone.value = it })
        AppTextFieldAddCard(
            text = password.value,
            label = "Password",
            onValueChange = { password.value = it })
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Gender", modifier = Modifier.padding(top = 10.dp))
            val radioOption = listOf("Male", "Female")
            val (selectedOption, onOptionSelected) = remember {
                mutableStateOf(radioOption[0])
            }
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth()
                    .selectableGroup(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                radioOption.forEach { text ->
                    Row(
                        Modifier
                            .height(56.dp)
                            .selectable(
                                selected = (text == selectedOption),
                                onClick = { onOptionSelected(text) },
                                role = Role.RadioButton
                            ),
                    ) {
                        RadioButton(selected = (text == selectedOption), onClick = null)
                        Text(
                            text = text,
                            style = MaterialTheme.typography.body1.merge(),
                            modifier = Modifier.padding(start = 16.dp)
                        )

                    }

                }
            }


        }

        PrimaryButton(text = "SignUp") {
            signUpModel.firstName = firstName.toString()
            signUpModel.lastName = lastName.toString()
            signUpModel.phone = phone.toString()
            signUpModel.password = password.toString()
            onDispatcher.invoke(SignUpContract.Intent.ToSmsCheck(signUpModel))
        }
    }

}


//@Preview(showBackground = true)
//@Composable
//fun SignUpScreenPreview() {
//    BankAppTheme {
//        SignUpScreen()
//    }
//}

