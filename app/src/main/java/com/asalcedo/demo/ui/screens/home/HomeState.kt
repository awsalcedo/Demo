package com.asalcedo.demo.ui.screens.home

import com.asalcedo.demo.domain.model.ClientModel

sealed class HomeState {
    object Loading : HomeState()
    data class Success(val clients: List<ClientModel> = emptyList()): HomeState()
    data class Error(val errorMessage: String): HomeState()
}
