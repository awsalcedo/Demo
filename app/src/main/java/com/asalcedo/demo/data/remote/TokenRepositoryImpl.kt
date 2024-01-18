package com.asalcedo.demo.data.remote

import android.util.Log
import com.asalcedo.demo.data.datastore.TokenDataStoreManager
import javax.inject.Inject

class TokenRepositoryImpl @Inject constructor(
    private val tokenService: TokenService,
    private val tokenDataStoreManager: TokenDataStoreManager
) : TokenRepository {
    override suspend fun getTokenApi(user: String, password: String): Boolean {
        val tokenResponse =
            tokenService.getTokenApi(user, password)

        return if (tokenResponse.status == 200 && tokenResponse.data.isNotEmpty()) {
            saveTokeDataStore(tokenResponse.data)
            Log.d("ALEX", tokenResponse.data)
            true
        } else {
            false
        }
    }

    private suspend fun saveTokeDataStore(token: String) {
        tokenDataStoreManager.saveToken(token)
        /*tokenDataStoreManager.getTokenFlow.collect { tokenDataStore ->
            Log.d("ALEX", tokenDataStore!!)
        }*/
    }
}
