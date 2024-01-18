package com.asalcedo.demo.ui.screens.login

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asalcedo.demo.domain.usecase.GetTokenUseCase
import com.asalcedo.demo.util.Response
import com.asalcedo.demo.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/****
 * Project: Bottom Navigation Bar Compose
 * From: com.asalcedo.demo.ui.screens
 * Created by Alex Salcedo Silva on 11/1/24 at 15:32
 * All rights reserve 2022.
 * En el ViewModel, se puede realizar un manejo adicional de excepciones para situaciones específicas de la interfaz de usuario,
 * como por ejemplo, si se produce un error inesperado que no fue manejado en el UseCase.
 ***/
@HiltViewModel
class LoginViewModel @Inject constructor(private val useCase: GetTokenUseCase) : ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _loginEnabled = MutableLiveData<Boolean>()
    val loginEnabled: LiveData<Boolean> = _loginEnabled

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _doLogin = MutableLiveData<Boolean>()
    val doLogin: LiveData<Boolean> = _doLogin

    private val _uiState = MutableLiveData<UiState<Boolean>>()
    val uiState: LiveData<UiState<Boolean>> = _uiState

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _loginEnabled.value = isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidPassword(password: String): Boolean = password.length > 5

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    suspend fun onLoginSelected() {

        viewModelScope.launch {
            //_uiState.value = UiState.Loading
            _isLoading.value = true
            when (val result = useCase(email.value!!, password.value!!)) {
                is Response.Success -> {
                    //navegar a HomeScreen
                    _doLogin.value = true
                }
                is Response.Error -> {
                    // Manejar el error, puedes acceder a result.errorMessage
                    _uiState.value = UiState.Error(result.errorMessage?: "Error desconocido" )
                    Log.e("LoginViewModel", "Error al obtener el token para realizar el login: ${result.errorMessage}")
                }
                else -> {
                    // Acciones o lógica adicional para casos no cubiertos
                    _uiState.value = UiState.Error("Error desconocido")
                    Log.e("LoginViewModel", "Caso por defecto: Error desconocido")
                    //_isLoading.value = false
                }
            }
            _isLoading.value = false

        }


    }
}