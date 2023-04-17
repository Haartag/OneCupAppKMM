package com.llinsoft.onecupappkmm.android.login

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.llinsoft.onecupappkmm.android.Screen

@Composable
fun LoginScreen(navController: NavController) {
    Button(onClick = { navController.navigate(Screen.RegistrationScreen.route) }) {
        Text(text = "sign up")
    }
}