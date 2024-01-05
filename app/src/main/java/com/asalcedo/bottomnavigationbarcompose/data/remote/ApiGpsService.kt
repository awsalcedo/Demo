package com.asalcedo.bottomnavigationbarcompose.data.remote

import retrofit2.http.Body
import retrofit2.http.POST

interface ApiGpsService {
    @POST("/api/v1/gettoken")
    suspend fun getToken(@Body tokenRequest: TokenRequest)
}

data class TokenRequest(
    val apiKey: String,
    val token: String,
    val username: String,
    val password: String
)

data class CommonRequest(
    val apiKey: String,
    val token: String
)

data class OtherRequest(
    val apiKey: String,
    val token: String,
    // Otros parámetros específicos de la solicitud
)