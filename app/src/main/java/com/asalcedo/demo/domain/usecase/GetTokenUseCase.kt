package com.asalcedo.demo.domain.usecase

import android.util.Log
import com.asalcedo.demo.data.remote.exception.TokenException
import com.asalcedo.demo.data.remote.token.TokenRepository
import com.asalcedo.demo.util.ResponseState
import javax.inject.Inject

/****
 * Project: Bottom Navigation Bar Compose
 * From: com.asalcedo.demo.domain.usecase
 * Created by Alex Salcedo Silva on 10/1/24 at 16:20
 * All rights reserve 2022.
 * Se maneja las excepciones generales que pueden surgir durante la obtención del token y las encapsula en un `Response`
 ***/
class GetTokenUseCase @Inject constructor(private val repository: TokenRepository) {
    suspend operator fun invoke(user: String, password: String): ResponseState<Int> {
        return try {
            val status = repository.getTokenApi(user, password)
            ResponseState.Success(status)
        } catch (e: TokenException) {
            Log.d("Alex", "Error al obtener el token")
            ResponseState.Error("Error al obtener el token")
        } catch (e: Exception) {
            Log.d("Alex", "Error desconocido: ${e.message}")
            ResponseState.Error("Error inseperado ${e.message}")

        }
    }

}