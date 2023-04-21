package com.llinsoft.onecupappkmm.domain.firebase

class PasswordChecker {
    fun checkAll(passwordState: PasswordRules): Boolean {
        return passwordState.eightSymbols && passwordState.haveCapitalLetter
                && passwordState.haveChar && passwordState.haveNumber && passwordState.samePass
    }
    fun getPasswordState(password: String, confirmPassword: String): PasswordRules {
        val capitals = Regex("[A-Z]")
        val numbers = Regex("[\\d]")
        val letters = Regex("[a-zA-Z]")
        return PasswordRules(
            eightSymbols = password.length >= 8,
            haveCapitalLetter = capitals.containsMatchIn(password),
            haveNumber = numbers.containsMatchIn(password),
            haveChar = letters.containsMatchIn(password),
            samePass = password == confirmPassword && password.isNotEmpty()
        )
    }
}