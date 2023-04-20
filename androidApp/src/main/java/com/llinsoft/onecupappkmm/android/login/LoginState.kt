package com.llinsoft.onecupappkmm.android.login

data class LoginState(
    val username: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isSnackbarVisible: Boolean = false,
    val snackbarMessage: String = "An unknown error occurred"
)