package com.asalcedo.demo.data.remote.token

interface TokenRepository {

    suspend fun getTokenApi(user: String, password: String): Int
}