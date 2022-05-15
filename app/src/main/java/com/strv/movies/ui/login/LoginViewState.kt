package com.strv.movies.ui.login

data class LoginViewState(
    val user: String = "",
    val password: String = "",
    val error: String? = null
)
