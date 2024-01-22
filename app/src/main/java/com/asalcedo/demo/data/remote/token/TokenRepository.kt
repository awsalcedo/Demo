package com.asalcedo.demo.data.remote.token

import kotlinx.coroutines.flow.Flow

interface TokenRepository {
    //suspend fun getTokenApi(user: String, password: String): Boolean
    suspend fun getTokenApi(user: String, password: String): Int
}