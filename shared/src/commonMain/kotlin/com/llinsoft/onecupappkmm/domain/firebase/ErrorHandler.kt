package com.llinsoft.onecupappkmm.domain.firebase

import com.llinsoft.onecupappkmm.util.ErrorTexts

class ErrorHandler {

    fun getLoginErrorText(error: String): String {
        return when(error) {
            ErrorTexts.FirebaseLogin.VERIFY.errorText -> "Error: Please verify your email address."
            ErrorTexts.FirebaseLogin.EMPTY.errorText -> "Error: Please enter your login and password."
            ErrorTexts.FirebaseLogin.NOACC.errorText -> "Error: No such account exists."
            ErrorTexts.FirebaseLogin.WPASS.errorText -> "Error: Incorrect password."
            else -> "An unknown error occurred"
        }
    }

    fun getRegistrationErrorText(error: String): String {
        return when(error) {
            ErrorTexts.FirebaseRegistration.SAME.errorText -> "Error: An account with this email " +
                    "already exists. Please try another email or log in to your existing account."
            ErrorTexts.FirebaseRegistration.NOEMAIL.errorText -> "Error: Invalid email format. " +
                    "Please enter a valid email address. "
            else -> "An unknown error occurred"
        }
    }
}