package com.asalcedo.demo.ui.screens.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asalcedo.demo.domain.usecase.GetTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/****
 * Project: Bottom Navigation Bar Compose
 * From: com.asalcedo.demo.ui.screens
 * Created by Alex Salcedo Silva on 11/1/24 at 15:32
 * All rights reserve 2022.
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
            _isLoading.value = true
            val result = useCase(email.value!!, password.value!!)
            if(result) {
                //navegar a HomeScreen
                _doLogin.value = true
            }
            _isLoading.value = false

        }


    }
}