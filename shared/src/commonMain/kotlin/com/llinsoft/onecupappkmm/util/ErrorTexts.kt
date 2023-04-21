package com.llinsoft.onecupappkmm.util

object ErrorTexts {
    enum class FirebaseLogin(
        val errorText: String
    ) {
        VERIFY("Email not verified"),
        EMPTY("Given String is empty or null"),
        NOACC("There is no user record corresponding to this identifier. The user may have been deleted."),
        WPASS("The password is invalid or the user does not have a password.")
    }

    enum class FirebaseRegistration(
        val errorText: String
    ) {
        SAME("The email address is already in use by another account."),
        NOEMAIL("The email address is badly formatted.")
    }
}