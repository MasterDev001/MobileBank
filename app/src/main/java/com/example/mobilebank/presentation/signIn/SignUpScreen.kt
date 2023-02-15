package com.example.mobilebank.presentation.signIn

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import com.example.mobilebank.presentation.theme.BankAppTheme

class SignUpScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        SignScreen()
    }

}

@Composable
fun SignScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
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
        AppTextField(hint = "First name") {}
        AppTextField(hint = "Last name") {}
        AppTextField(hint = "Date of birth") {}
        AppTextField(hint = "Phone number") {}
        AppTextField(hint = "Password") {}
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


    }

}


@Composable
fun AppTextField(
    hint: String,
    testTag: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    textStyle: TextStyle = TextStyle(),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit
) {
    val name by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = name,
        onValueChange = onValueChange,
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


@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    BankAppTheme {
        SignUpScreen()
    }
}

