package app.main.hundreddaysofcode.signInUpPages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import app.main.hundreddaysofcode.R

@Composable
fun SignUpPG(
    navigationToLogInPG:()->Unit,
    state: SignUpState,
    onEvent: (SignUpEvent) -> Unit
){
    var isEmailValid by remember { mutableStateOf(true) }

    var isPasswordValid by remember { mutableStateOf(true) }

    var isRepeatPasswordValid by remember { mutableStateOf(true) }

    var bottomSize by remember { mutableIntStateOf(225) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.mainsc),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize())
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 220.dp, bottom = bottomSize.dp)
            .border(
                3.dp,
                Color.White,
                shape = RoundedCornerShape(8)
            )
            .background(
                Color(0xAAAABAC6).copy(alpha = 0.7F),
                shape = RoundedCornerShape(8)
            )
            .graphicsLayer(
                alpha = 0.8F
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {

        OutlinedTextField(value = state.username,
            onValueChange = {
                onEvent(SignUpEvent.SetUsername(it))
                bottomSize = 225},
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            leadingIcon = { Icon(
                Icons.Outlined.Person,
                contentDescription = null) },
            label = { Text(text = "Username") }
        )
        OutlinedTextField(value = state.email,
            onValueChange = {
                onEvent(SignUpEvent.SetEmail(it))
                isEmailValid = isEmailValid(it)
                bottomSize = 190
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            leadingIcon = {
                Icon(Icons.Outlined.Email,
                contentDescription = null) },
            label = { Text(text = "Email")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            isError = !isEmailValid,
            colors = if (!isEmailValid) {
                OutlinedTextFieldDefaults.colors(Color(0xFFFFE0E0))
            } else {
                OutlinedTextFieldDefaults.colors()
            }
        )

        if (!isEmailValid) {
            BasicText(
                text = "Invalid Email address",
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }
        OutlinedTextField(value = state.password,
            onValueChange = {
                onEvent(SignUpEvent.SetPassword(it))
                isPasswordValid = isPasswordValid(it)
                bottomSize = 190},
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            leadingIcon = {
                Icon(Icons.Outlined.Lock,
                contentDescription = null) },
            label = { Text(text = "Password")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            isError = !isPasswordValid,
            visualTransformation = PasswordVisualTransformation(),
            colors = if (!isPasswordValid) {
                OutlinedTextFieldDefaults.colors(Color(0xFFFFE0E0))
            } else {
                OutlinedTextFieldDefaults.colors()
            }
        )
        OutlinedTextField(value = state.repeatingPassword,
            onValueChange = {
                onEvent(SignUpEvent.SetRepeatingPassword(it))
                isRepeatPasswordValid = isRepeatPasswordValid(it, state.password)
                bottomSize = 190},
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            leadingIcon = { Icon(Icons.Outlined.Lock,
                contentDescription = null) },
            label = { Text(text = "Confirm Password")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            isError = !isRepeatPasswordValid,
            visualTransformation = PasswordVisualTransformation(),
            colors = if (!isRepeatPasswordValid) {
                OutlinedTextFieldDefaults.colors(Color(0xFFFFE0E0))
            } else {
                OutlinedTextFieldDefaults.colors()
            }
        )

        Button(
            onClick = {
                navigationToLogInPG()
                bottomSize = 225
                onEvent(SignUpEvent.SaveUser)
            },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(Color(0XAA1F51FF))
        )
        {
            Text(text = "Sign Up")
        }
    }
}
fun isEmailValid(email: String): Boolean {
    val emailRegex = Regex("^([a-zA-Z0-9_\\-]+)@([a-zA-Z]+)\\.([a-zA-Z]{2,5})$")
    return emailRegex.matches(email)
}

fun isPasswordValid(password: String): Boolean {
    val lengthRegex = Regex("^.{8,}$")
    val uppercaseRegex = Regex(".*[A-Z].*")
    val symbolRegex = Regex(".*[!@#\$%&*(){}\\[\\]].*")
    val digitRegex = Regex(".*\\d.*")

    return lengthRegex.matches(password) &&
            uppercaseRegex.matches(password) &&
            symbolRegex.matches(password) &&
            digitRegex.matches(password)
}

fun isRepeatPasswordValid(repeatPassword: String, password: String): Boolean {
    return repeatPassword == password
}