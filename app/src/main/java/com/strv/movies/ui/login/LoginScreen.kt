package com.strv.movies.ui.login

import android.widget.TextView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.strv.movies.R
import com.strv.movies.ui.theme.login_facebookLogo

@Composable
fun LogInScreen() {
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var passwordVisibility by remember {
        mutableStateOf(false)
    }
    val icon = if (passwordVisibility) {
        painterResource(id = R.drawable.ic_invisible)
    } else {
        painterResource(id = R.drawable.ic_visible)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_login_logo),
            contentDescription = "App logo",
            modifier = Modifier.padding(top = 20.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(R.string.login_login),
            style = MaterialTheme.typography.h2
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(0.8f),
            value = username,
            onValueChange = { username = it },
            label = {
                Text(
                    text = stringResource(
                        R.string.login_username
                    )
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_email),
                    contentDescription = stringResource
                        (R.string.login_contentDesc_emailIcon)
                )
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(0.8f),
            value = password,
            onValueChange = { password = it },
            label = {
                Text(
                    text = stringResource(
                        R.string.login_password
                    )
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (passwordVisibility) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_key),
                    contentDescription = stringResource(
                        R.string.login_contentDesc_passwordIcon
                    )
                )
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(
                        painter = icon,
                        contentDescription = stringResource(
                            R.string.login_contentDesc_visibilityIcon
                        )
                    )

                }
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { },
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text(
                text = stringResource(id = R.string.login_login),
                modifier = Modifier.align(CenterVertically)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        ClickableText(
            text = AnnotatedString(stringResource(R.string.login_forgotPassword)),
            onClick = {},
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(0.6f),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(
                onClick = { },
                modifier = Modifier
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_login_google),
                    contentDescription = stringResource(
                        R.string.login_contentDesc_googleIcon
                    ),
                )
            }


            IconButton(
                onClick = { },
                modifier = Modifier
                    .clip(CircleShape)
                    .background(color = login_facebookLogo)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_login_facebook),
                    contentDescription = stringResource(
                        R.string.login_contentDesc_facebookIcon
                    )
                )
            }

        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        ClickableText(
            text = AnnotatedString(stringResource(R.string.login_signup)),
            onClick = {},
            modifier = Modifier
                .align(BottomCenter)
                .padding(bottom = 18.dp),
            style = TextStyle(textDecoration = TextDecoration.Underline)

        )
    }
}