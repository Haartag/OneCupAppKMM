package com.llinsoft.onecupappkmm.domain.serialization

import com.llinsoft.onecupappkmm.domain.database.TemplateEntry
import com.llinsoft.onecupappkmm.domain.firebase.PasswordRules
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

    fun pack(list: List<TemplateEntry>): String {
        return Json.encodeToString(list)
    }

    fun unpack(json: String): List<TemplateEntry> {
        return Json.decodeFromString(json)
    }
}