package com.llinsoft.onecupappkmm.domain.database

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class Coffee(
    val id: Long?,
    val title: String,
    val description: String,
    val template: List<TemplateEntry>,
    val isFavourite: Boolean,
    val created: LocalDateTime
)

@Serializable
data class TemplateEntry(
    val id: Int,
    val time: Int,
    val name: String,
    val description: String
)


