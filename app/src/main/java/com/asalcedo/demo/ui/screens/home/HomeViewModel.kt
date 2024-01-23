package com.asalcedo.demo.ui.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asalcedo.demo.domain.model.ClientModel
import com.asalcedo.demo.domain.usecase.GetClientsUseCase
import com.asalcedo.demo.util.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val usecase: GetClientsUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<HomeState>()
    val uiState: LiveData<HomeState> = _uiState

    private val _clientList = MutableLiveData<List<ClientModel>>()
    val clientList: LiveData<List<ClientModel>> = _clientList

    suspend fun onGetClients() {
        viewModelScope.launch {
            _uiState.value = HomeState.Loading
            when (val result = usecase.invoke()) {
                is ResponseState.Error -> HomeState.Error(result.errorMessage)
                is ResponseState.Success -> {
                    _uiState.value = HomeState.Success(result.data)
                }
            }
        }
    }
}