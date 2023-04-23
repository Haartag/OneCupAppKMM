package com.llinsoft.onecupappkmm.android.login

data class LoginState(
    val loginTextFieldState: LoginTextFieldsState = LoginTextFieldsState(),
    val loginErrorState: LoginErrorState = LoginErrorState()
)

data class LoginTextFieldsState(
    val username: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
)
data class LoginErrorState(
    val isSnackbarVisible: Boolean = false,
    val snackbarMessage: String = "An unknown error occurred"
)