package com.llinsoft.onecupappkmm.domain.firebase

import com.llinsoft.onecupappkmm.util.ErrorTexts

class ErrorHandler {

    //error.contains due to difference in Android and iOS error messages

    fun getLoginErrorText(error: String): String {
        return when {
            error.contains(ErrorTexts.FirebaseLogin.VERIFY.errorText) -> "Error: Please verify your email address."
            error.contains(ErrorTexts.FirebaseLogin.EMPTY.errorText) -> "Error: Please enter your login and password."
            error.contains(ErrorTexts.FirebaseLogin.NOACC.errorText) -> "Error: No such account exists."
            error.contains(ErrorTexts.FirebaseLogin.WPASS.errorText) -> "Error: Incorrect password."
            else -> "An unknown error occurred"
        }
    }

    fun getRegistrationErrorText(error: String): String {
        return when {
            error.contains(ErrorTexts.FirebaseRegistration.SAME.errorText) -> "Error: An account with this email " +
                    "already exists. Please try another email or log in to your existing account."
            error.contains(ErrorTexts.FirebaseRegistration.NOEMAIL.errorText) -> "Error: Invalid email format. " +
                    "Please enter a valid email address. "
            else -> "An unknown error occurred"
        }
    }
}