package com.llinsoft.onecupappkmm.android.registration

data class RegistrationState(
    val email: String = "",
    var password: String = "",
    var confirmPassword: String = "",
    var isLoading: Boolean = false
)
