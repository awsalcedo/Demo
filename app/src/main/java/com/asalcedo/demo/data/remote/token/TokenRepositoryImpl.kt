package com.asalcedo.demo.data.remote.token

import android.util.Log
import com.asalcedo.demo.data.datastore.TokenDataStoreManager
import javax.inject.Inject

class TokenRepositoryImpl @Inject constructor(
    private val tokenRemoteDataSourceImpl: TokenRemoteDataSourceImpl,
    private val tokenDataStoreManager: TokenDataStoreManager
) : TokenRepository {
    override suspend fun getTokenApi(user: String, password: String): Int {
        val tokenResponse =
            tokenRemoteDataSourceImpl.getTokenApi(user, password)

        return if (tokenResponse.status == 200 && tokenResponse.data.isNotEmpty()) {
            saveTokeDataStore(tokenResponse.data)
            Log.d("ALEX", tokenResponse.data)
            tokenResponse.status
        } else {
            -1
        }
    }

    private suspend fun saveTokeDataStore(token: String) {
        tokenDataStoreManager.saveToken(token)
        /*tokenDataStoreManager.getTokenFlow.collect { tokenDataStore ->
            Log.d("ALEX", tokenDataStore!!)
        }*/
    }
}
