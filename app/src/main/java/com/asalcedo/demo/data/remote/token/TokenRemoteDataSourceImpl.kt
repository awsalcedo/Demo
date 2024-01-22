package com.asalcedo.demo.data.remote.token

import com.asalcedo.demo.data.remote.model.TokenResponse
import javax.inject.Inject


/****
 * Project: Bottom Navigation Bar Compose
 * From: com.asalcedo.demo.data.remote
 * Created by Alex Salcedo Silva on 12/1/24 at 13:00
 * All rights reserve 2022.
 ***/
class TokenRemoteDataSourceImpl @Inject constructor(private val tokenApiService: TokenApiService) :
    TokenRemoteDataSource {
    override suspend fun getTokenApi(user: String, password: String): TokenResponse {
        return tokenApiService.getToken(username = user, password = password)
    }
}