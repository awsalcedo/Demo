package com.asalcedo.demo.util

/**
 * Permite manejar el estado en la capa de UI
 *
 * @param T
 * @constructor Create empty Ui state
 */
sealed class UiState<out T> {
    data class Success<out T>(val data: T) : UiState<T>()
    data class Error(val errorMessage: String) : UiState<Nothing>()
    object Loading : UiState<Nothing>()
}
