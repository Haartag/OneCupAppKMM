package com.llinsoft.onecupappkmm.domain.firebase

import com.llinsoft.onecupappkmm.Resource
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.FirebaseUser
import dev.gitlive.firebase.auth.auth

class FirebaseManager {
    private val auth: FirebaseAuth = Firebase.auth

    suspend fun signUpWithEmail(email: String, password: String): Resource<Unit> {
        return try {
            val userCredential = auth.createUserWithEmailAndPassword(email, password)
            sendEmailVerification(userCredential.user)
            Resource.Success(Unit)
        } catch (e: Exception) {
            // Handle sign up error
            Resource.Error(e.message ?: "Unknown error")
        }
    }


    private suspend fun sendEmailVerification(user: FirebaseUser?) {
        user?.let {
            try {
                it.sendEmailVerification()
            } catch (e: Exception) {
                // Handle email verification error
            }
        }
    }
}