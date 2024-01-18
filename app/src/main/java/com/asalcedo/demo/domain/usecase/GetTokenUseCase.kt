package com.asalcedo.demo.domain.usecase

import com.asalcedo.demo.data.remote.TokenRepository
import com.asalcedo.demo.util.Response
import javax.inject.Inject

/****
 * Project: Bottom Navigation Bar Compose
 * From: com.asalcedo.demo.domain.usecase
 * Created by Alex Salcedo Silva on 10/1/24 at 16:20
 * All rights reserve 2022.
 * Se maneja las excepciones generales que pueden surgir durante la obtención del token y las encapsula en un `Response`
 ***/
class GetTokenUseCase @Inject constructor(private val repository: TokenRepository) {
    suspend operator fun invoke(user: String, password: String): Response<Boolean> =
        try {
            val response = repository.getTokenApi(user, password)
            Response.Success(response)
        } catch (e: Exception) {
            Response.Error("Error al obtener el token: ${e.message}")
        }
}