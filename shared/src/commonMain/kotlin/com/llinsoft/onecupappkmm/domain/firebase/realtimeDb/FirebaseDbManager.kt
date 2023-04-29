package com.llinsoft.onecupappkmm.domain.firebase.realtimeDb

import com.llinsoft.onecupappkmm.Resource
import com.llinsoft.onecupappkmm.domain.serialization.Serialization
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.database.database
import kotlinx.coroutines.flow.first

class FirebaseDbManager(
    private val serialization: Serialization
) {

    private val database = Firebase.database
    private val reference = database.reference("blueprint")

    /**
     * Insert blueprint json into Firebase Realtime DB
     */
    suspend fun saveBlueprint(blueprint: Blueprint): Resource<Unit> {
        return try {
            val jsonBlueprint = serialization.blueprintToString(blueprint)
            reference.child("blueprint ${blueprint.id}").setValue(jsonBlueprint)
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Unknown error")
        }
    }

    /**
     * Get all blueprint json from Firebase Realtime DB
     */
    suspend fun getAllBlueprints(): List<Blueprint> {
        val items = mutableListOf<Blueprint>()
        reference.valueEvents.first().children.forEach {
            items.add(serialization.stringToBlueprint(it.value()))
        }
        return items
    }
}
