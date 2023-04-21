package com.llinsoft.onecupappkmm.android.login

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.llinsoft.onecupappkmm.android.Screen
import com.llinsoft.onecupappkmm.android.common_composables.ErrorSnackbar

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginScreenViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    AnimatedVisibility(
        visible = state.isSnackbarVisible,
        enter = slideInVertically() + fadeIn(),
        exit = slideOutVertically() + fadeOut()
    ) {
        ErrorSnackbar(message = state.snackbarMessage)
    }

    Column() {
        EmailLogin(
            username = state.username,
            password = state.password,
            navController = navController
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun EmailLogin(
    username: String,
    password: String,
    navController: NavController,
    viewModel: LoginScreenViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = username,
            onValueChange = viewModel::onEmailTextChange,
            label = { Text("Email address") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(
            value = password,
            onValueChange = viewModel::onPasswordTextChange,
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            viewModel.onIsLoadingChange(true)
            viewModel.signIn(username, password)
        }) {
            Text(text = "Sing in")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            navController.navigate(Screen.RegistrationScreen.route)
        }) {
            Text(text = "Sign up")
        }
    }
}