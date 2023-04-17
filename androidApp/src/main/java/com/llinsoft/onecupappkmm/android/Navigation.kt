package com.llinsoft.onecupappkmm.android

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.llinsoft.onecupappkmm.android.login.LoginScreen
import com.llinsoft.onecupappkmm.android.registration.RegistrationScreen

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login")
    object RegistrationScreen : Screen("registration")
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.RegistrationScreen.route) {
            RegistrationScreen(navController = navController)
        }
    }
}
