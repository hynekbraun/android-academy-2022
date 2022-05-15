package com.strv.movies.ui.login

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.strv.movies.ui.movieslist.MoviesListViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
@Inject constructor() : ViewModel() {

    private val _viewState = MutableStateFlow(LoginViewState())
    val viewState = _viewState.asStateFlow()

    fun updateName(input: String) {
        _viewState.update {
            it.copy(user = input)
        }
        Log.d("TAG", "LoginViewModel - ${_viewState.value.user}")
    }

    fun updatePassword(input: String) {
        _viewState.update {
            it.copy(password = input)

        }
        Log.d("TAG", "LoginViewModel - ${_viewState.value.password}")
    }

    fun login(): Boolean {
        val userName = _viewState.value.user
        val password = _viewState.value.password
        if (userName.isNotBlank() && password.isNotBlank()) {
            return true
        } else {
            _viewState.update { it.copy(error = "Please fill in user name and password") }
           Log.d("TAG", "LoginViewModel - error")
            return false
        }
    }

}