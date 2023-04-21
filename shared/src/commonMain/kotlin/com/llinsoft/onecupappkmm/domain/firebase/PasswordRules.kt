package com.llinsoft.onecupappkmm.domain.firebase

import kotlinx.serialization.Serializable

@Serializable
data class PasswordRules(
    val eightSymbols: Boolean = false,
    val haveCapitalLetter: Boolean = false,
    val haveNumber: Boolean = false,
    val haveChar: Boolean = false,
    val samePass: Boolean = false
)
