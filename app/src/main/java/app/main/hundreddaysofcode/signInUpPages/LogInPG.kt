package app.main.hundreddaysofcode.signInUpPages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.main.hundreddaysofcode.R

@SuppressLint("SuspiciousIndentation")
@Composable
fun LogInPG(
    navigationToSignUpPG:()->Unit,
    state: SignUpState
) {
    var username by remember{ mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var isUsernameExist by remember {
        mutableStateOf(true)
    }
//    var isPasswordExist by remember {
//        mutableStateOf(true)
//    }

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color(0XAA1F51FF))) {
            append("click here")
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.mainsc),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize())
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 290.dp, bottom = 290.dp)
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
        OutlinedTextField(
            value = state.username,
            onValueChange = {
                isUsernameExist = isUserExist(it, state.username)
                if (isUsernameExist)
                username = it },
            singleLine = true,
            leadingIcon = { Icon(Icons.Outlined.Person,
                contentDescription = null) },
            label = { Text(text = "Username") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
        )
        OutlinedTextField(value = password,
            onValueChange = { password = it },
            singleLine = true,
            leadingIcon = { Icon(Icons.Outlined.Lock,
                contentDescription = null) },
            label = {
                Text(text = "Password")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
        )
        Row {
            Column {
                Text(
                    text = "if you don't have an account yet, ",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Column {
                ClickableText(
                    text = annotatedString,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    onClick = {
                        navigationToSignUpPG()
                    }
                )
            }
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors =ButtonDefaults.buttonColors(Color(0XAA1F51FF))
        )
            {
            Text(text = "Log In")
        }
    }
}

fun isUserExist(usernameToCheck: String, usernameSrc: String): Boolean{
    return usernameToCheck == usernameSrc
}

//fun isPassExist(passwordToCheck: String, passwordSrc: SignUpState): Boolean{
//    return passwordToCheck == passwordSrc.username
//}