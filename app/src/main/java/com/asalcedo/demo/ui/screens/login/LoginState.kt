package com.asalcedo.demo.ui.screens.login

/****
 * Project: Bottom Navigation Bar Compose
 * From: com.asalcedo.demo.ui.screens
 * Created by Alex Salcedo Silva on 11/1/24 at 17:54
 * All rights reserve 2022.
 * Permite manejar los estados de la UI
 ***/

sealed class LoginState {
    object Loading : LoginState()
    data class Success(val status: Int) : LoginState()
    data class Error(val error: String) : LoginState()

}
