package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colors.background) {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    MaterialTheme {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            InputEmail()
            InputPassword()
            ForgotPassword()
            Login()
            TextLoginAnotherAccount()
            LoginFacebook()
            LoginGoogle()
            LoginAppleID()
            RegisterFromHere()
        }
    }
}

@Composable
fun InputEmail() {
    var email by rememberSaveable { mutableStateOf("") }
    TextField(
        value = email,
        onValueChange = { email = it },
        maxLines = 1,
        placeholder = { Text(text = stringResource(id = R.string.email)) },
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
            .height(50.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorResource(id = R.color.black),
            disabledTextColor = colorResource(id = R.color.grey),
            backgroundColor = colorResource(id = R.color.white),
            focusedIndicatorColor = colorResource(id = R.color.grey),
            unfocusedIndicatorColor = colorResource(id = R.color.grey),
            disabledIndicatorColor = colorResource(id = R.color.black)
        )
    )
}

@Composable
fun InputPassword() {
    var password by rememberSaveable { mutableStateOf("") }
    TextField(
        value = password,
        onValueChange = { password = it },
        maxLines = 1,
        placeholder = { Text(stringResource(id = R.string.password)) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
            .height(50.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorResource(id = R.color.black),
            disabledTextColor = colorResource(id = R.color.grey),
            backgroundColor = colorResource(id = R.color.white),
            focusedIndicatorColor = colorResource(id = R.color.grey),
            unfocusedIndicatorColor = colorResource(id = R.color.grey),
            disabledIndicatorColor = colorResource(id = R.color.black)
        )
    )
}

@Composable
fun ForgotPassword() {
    Text(
        text = stringResource(id = R.string.forgot_password),
        textDecoration = TextDecoration.Underline,
        color = colorResource(id = R.color.blue),
        textAlign = TextAlign.End,
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
    )
}

@Composable
fun Login() {
    Text(
        text = stringResource(id = R.string.login),
        textAlign = TextAlign.Center,
        fontSize = 16.sp,
        color = colorResource(id = R.color.black),
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
            .background(colorResource(id = R.color.grey333))
            .padding(all = 10.dp)
    )
}

@Composable
fun TextLoginAnotherAccount() {
    Text(
        text = stringResource(id = R.string.login_another_account),
        color = colorResource(id = R.color.grey83),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
    )
}

@Composable
fun LoginFacebook() {
    Box(
        modifier = Modifier
            .padding(all = 8.dp)
            .border(1.dp, color = colorResource(id = R.color.grey333)),
        contentAlignment = Alignment.Center
    ) {
        ConstraintLayout {
            val (image, text) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.ic_facebook),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start, margin = 64.dp)
                    },
                alignment = Alignment.CenterStart
            )
            Text(
                text = stringResource(id = R.string.login_facebook),
                color = colorResource(id = R.color.black),
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .constrainAs(text) {
                        top.linkTo(image.top)
                        bottom.linkTo(image.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
        }
    }
}

@Composable
fun LoginGoogle() {
    Box(
        modifier = Modifier
            .padding(all = 8.dp)
            .border(1.dp, color = colorResource(id = R.color.grey333)),
        contentAlignment = Alignment.Center
    ) {
        ConstraintLayout {
            val (image, text) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start, margin = 64.dp)
                    },
                alignment = Alignment.CenterStart
            )
            Text(
                text = stringResource(id = R.string.login_google),
                color = colorResource(id = R.color.black),
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .constrainAs(text) {
                        top.linkTo(image.top)
                        bottom.linkTo(image.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
        }
    }
}

@Composable
fun LoginAppleID() {
    Box(
        modifier = Modifier
            .padding(all = 8.dp)
            .border(1.dp, color = colorResource(id = R.color.grey333)),
        contentAlignment = Alignment.Center
    ) {
        ConstraintLayout {
            val (image, text) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.ic_apple),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start, margin = 64.dp)
                    },
                alignment = Alignment.CenterStart
            )
            Text(
                text = stringResource(id = R.string.login_apple_id),
                color = colorResource(id = R.color.black),
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .constrainAs(text) {
                        top.linkTo(image.top)
                        bottom.linkTo(image.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
        }
    }
}

@Composable
fun RegisterFromHere() {
    Text(
        text = stringResource(id = R.string.register_from_here),
        textDecoration = TextDecoration.Underline,
        color = colorResource(id = R.color.black),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
    )
}