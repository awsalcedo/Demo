package com.asalcedo.demo.util

/**
 * Permite manejar el estado en la capa de UI
 *
 * @param T
 * @constructor Create empty Ui state
 */
sealed class UiState<out T> {
    data class Loading<out T>(val isLoading: T? = null) : UiState<T>()
    data class Success<out T>(val data: T? = null) : UiState<T>()
    data class Error<out T>(val errorMessage: T? = null) : UiState<Nothing>()

}
