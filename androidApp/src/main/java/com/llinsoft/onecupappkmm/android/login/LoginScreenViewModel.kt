package com.llinsoft.onecupappkmm.android.login

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.llinsoft.onecupappkmm.Status
import com.llinsoft.onecupappkmm.android.util.LogTags
import com.llinsoft.onecupappkmm.domain.firebase.ErrorHandler
import com.llinsoft.onecupappkmm.domain.firebase.FirebaseManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val firebaseManager: FirebaseManager,
    private val errorHandler: ErrorHandler
): ViewModel() {

    private val email = savedStateHandle.getStateFlow("email", "")
    private val password = savedStateHandle.getStateFlow("password", "")
    private val isLoading = savedStateHandle.getStateFlow("isLoading", false)

    private val isSnackbarVisible = savedStateHandle.getStateFlow("isSnackbarVisible", false)
    private val snackbarMessage = savedStateHandle.getStateFlow("snackbarMessage", "An unknown error occurred")

    val textFieldsState = combine(
        email,
        password,
        isLoading,
    ) { email, password, isLoading ->
        LoginTextFieldsState(
            username = email,
            password = password,
            isLoading = isLoading,
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), LoginTextFieldsState())

    val errorState = combine(
        isSnackbarVisible,
        snackbarMessage
    ) { isSnackbarVisible, snackbarMessage ->
        LoginErrorState(
        isSnackbarVisible = isSnackbarVisible,
        snackbarMessage = snackbarMessage
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), LoginErrorState())

    val state = combine(
        textFieldsState,
        errorState
    ) { textFieldsState, errorState ->
        LoginState(
            loginTextFieldState = textFieldsState,
            loginErrorState = errorState
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), LoginState())

    fun onEmailTextChange(text: String) {
        savedStateHandle["email"] = text
    }

    fun onPasswordTextChange(text: String) {
        savedStateHandle["password"] = text
    }

    fun onIsLoadingChange(isLoading: Boolean) {
        savedStateHandle["isLoading"] = isLoading
    }

    fun onIsSnackbarVisibleChange(isSnackbarVisible: Boolean) {
        savedStateHandle["isSnackbarVisible"] = isSnackbarVisible
    }

    fun onSnackbarMessageChange(snackbarMessage: String) {
        savedStateHandle["snackbarMessage"] = snackbarMessage
    }

    private fun cancelLoading() = onIsLoadingChange(false)
    private fun enableError(message: String) {
        onSnackbarMessageChange(message)
        onIsSnackbarVisibleChange(true)
    }
    private fun disableError() {
        onSnackbarMessageChange("")
        onIsSnackbarVisibleChange(false)
    }

    fun signIn(
        email: String,
        password: String,
    ) {
        viewModelScope.launch {
            val result = firebaseManager.signInWithEmail(email = email, password = password)
            when (result.status) {
                Status.SUCCESS  -> {
                    cancelLoading()
                    Log.d(LogTags.Tags.LOG.tag, "signIn: SUCCESS")
                    //TODO Navigation
                }
                Status.ERROR -> {
                    cancelLoading()
                    Log.d(LogTags.Tags.LOG.tag, "signIn: ${result.message}")
                    showVerifySnackbar(result.message ?: "")
                }
            }
        }
    }

    private fun showVerifySnackbar(message: String) {
        viewModelScope.launch {
            enableError(errorHandler.getLoginErrorText(message))
            delay(4000)
            disableError()
        }
    }
}