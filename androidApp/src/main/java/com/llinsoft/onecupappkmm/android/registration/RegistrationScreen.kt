package com.llinsoft.onecupappkmm.android.registration

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
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

@Composable
fun FirebaseEmailRegForm(
    viewModel: RegistrationScreenViewModel = hiltViewModel(),
) {

    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = state.email,
            onValueChange = viewModel::onEmailTextChange,
            label = { Text("Email address") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(
            value = state.password,
            onValueChange = viewModel::onPasswordTextChange,
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = state.confirmPassword,
            onValueChange = viewModel::onConfirmPasswordTextChange,
            label = { Text("Confirm password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                if (state.password != state.confirmPassword) {
                    return@Button
                }
                viewModel.onIsLoadingChange(true)
                viewModel.createAccount(state.email, state.password)

            },
            modifier = Modifier.fillMaxWidth(0.5f),
            enabled = !state.isLoading &&
                    state.email.isNotEmpty() &&
                    state.password.isNotEmpty() &&
                    state.confirmPassword.isNotEmpty()
        //TODO Make password rules
        ) {
            if (state.isLoading) {
                CircularProgressIndicator()
            } else {
                Text(text = "Registration")
            }
        }
    }
}