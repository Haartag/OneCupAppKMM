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
}