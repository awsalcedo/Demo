package com.asalcedo.demo.data.remote

import com.asalcedo.demo.data.remote.model.TokenResponse
import kotlinx.coroutines.flow.Flow

interface TokenRepository {
    suspend fun getTokenApi(user: String, password: String): Boolean
}