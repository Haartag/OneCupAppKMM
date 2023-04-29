package com.llinsoft.onecupappkmm.domain.serialization

import com.llinsoft.onecupappkmm.domain.database.TemplateEntry
import com.llinsoft.onecupappkmm.domain.firebase.auth.PasswordRules
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Serialization {

    fun passwordRulesToJson(data: PasswordRules): String {
        return Json.encodeToString(data)
    }

    fun jsonToPasswordRules(json: String): PasswordRules {
        return Json.decodeFromString(json)
    }

    fun TemplateToString(list: List<TemplateEntry>): String {
        return Json.encodeToString(list)
    }

    fun stringToTemplate(json: String): List<TemplateEntry> {
        return Json.decodeFromString(json)
    }
}