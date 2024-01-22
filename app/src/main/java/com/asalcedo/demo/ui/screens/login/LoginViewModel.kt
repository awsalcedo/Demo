package com.asalcedo.demo.ui.screens.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asalcedo.demo.domain.usecase.GetTokenUseCase
import com.asalcedo.demo.util.ResponseState
import com.asalcedo.demo.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

    /*private val _navigateToHome = MutableLiveData<Boolean>()
    val navigateToHome: LiveData<Boolean> = _navigateToHome*/

    private val _uiState = MutableLiveData<UiState<Int>>()
    val uiState: LiveData<UiState<Int>> = _uiState

    private val _loginUiState = MutableLiveData<LoginState>()
    val loginUiState: LiveData<LoginState> = _loginUiState

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
            //_uiState.value = UiState.Loading(isLoading = true)
            _loginUiState.value = LoginState.Loading

            val result = withContext(Dispatchers.IO) {
                useCase(email.value!!, password.value!!)
            }

            when (result) {
                is ResponseState.Success -> {
                    //_uiState.value = UiState.Success(result.data)
                    _loginUiState.value = LoginState.Success(result.data)
                    //_uiState.value = UiState.Loading(isLoading = false)
                    //_navigateToHome.value = true

                }

                is ResponseState.Error -> {
                    _loginUiState.value = LoginState.Error(result.errorMessage)
                    //_uiState.value = UiState.Error(result.errorMessage)
                    //_uiState.value = UiState.Loading(isLoading = false)
                }

            }

            /*when (val result = useCase(email.value!!, password.value!!)) {
                is ResponseState.Success -> {
                    _uiState.value = UiState.Success(result.data)
                    _uiState.value = UiState.Loading(isLoading = false)
                    //_navigateToHome.value = true

                }

                is ResponseState.Error -> {
                    _uiState.value = UiState.Error(result.errorMessage)
                    _uiState.value = UiState.Loading(isLoading = false)
                }

            }*/
        }


    }
}