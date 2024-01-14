package com.asalcedo.demo.data.remote

import com.asalcedo.demo.data.remote.model.TokenResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface TokenApiService {
    @FormUrlEncoded
    @POST("gettoken")

    suspend fun getToken(
        @Field("apikey") apikey: String,
        @Field("token") token: String? = null,
        @Field("username") username: String,
        @Field("password") password: String
    ): TokenResponse
}

data class TokenRequest(
    val apiKey: String,
    val token: String? = null,
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