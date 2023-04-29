package com.llinsoft.onecupappkmm.domain.firebase.realtimeDb

import kotlinx.serialization.Serializable

@Serializable
data class Blueprint(
    val id: Long?,
    val title: String,
    val description: String,
    val recipe: String
)

