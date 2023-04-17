package com.llinsoft.onecupappkmm.android.registration

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.llinsoft.onecupappkmm.Resource
import com.llinsoft.onecupappkmm.domain.firebase.FirebaseManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationScreenViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val firebaseManager: FirebaseManager
) : ViewModel() {

    private val email = savedStateHandle.getStateFlow("email", "")
    private val password = savedStateHandle.getStateFlow("password", "")
    private val confirmPassword = savedStateHandle.getStateFlow("confirmPassword", "")
    private val isLoading = savedStateHandle.getStateFlow("isLoading", false)

    val state = combine(
        email,
        password,
        confirmPassword,
        isLoading
    ) { email, password, confirmPassword, isLoading ->
        RegistrationState(
            email = email,
            password = password,
            confirmPassword = confirmPassword,
            isLoading = isLoading
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), RegistrationState())


    fun onEmailTextChange(text: String) {
        savedStateHandle["email"] = text
    }

    fun onPasswordTextChange(text: String) {
        savedStateHandle["password"] = text
    }

    fun onConfirmPasswordTextChange(text: String) {
        savedStateHandle["confirmPassword"] = text
    }

    fun onIsLoadingChange(isLoading: Boolean) {
        savedStateHandle["isLoading"] = isLoading
    }

    private fun cancelLoading() = onIsLoadingChange(false)


    fun createAccount(
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            val result = firebaseManager.signUpWithEmail(email = email, password = password)
            when (result) {
                is Resource.Success -> {
                    cancelLoading()
                    //TODO Navigation
                }
                is Resource.Error -> {
                    cancelLoading()
                    //TODO Error handling
                }
            }
        }
    }
}