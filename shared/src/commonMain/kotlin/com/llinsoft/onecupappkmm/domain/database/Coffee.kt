package com.llinsoft.onecupappkmm.domain.database

import kotlinx.datetime.LocalDateTime

data class Coffee(
    val id: Long?,
    val title: String,
    val description: String,
    val template: String,
    val isFavourite: Boolean,
    val created: LocalDateTime
)
