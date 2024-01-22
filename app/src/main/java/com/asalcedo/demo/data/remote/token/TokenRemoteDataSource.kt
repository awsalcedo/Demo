package com.asalcedo.demo.data.remote.token

import com.asalcedo.demo.data.remote.model.TokenResponse

interface TokenRemoteDataSource {
    suspend fun getTokenApi(user: String, password: String): TokenResponse
}