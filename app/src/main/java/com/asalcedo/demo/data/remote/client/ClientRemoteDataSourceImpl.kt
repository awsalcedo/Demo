package com.asalcedo.demo.data.remote.client

import android.util.Log
import com.asalcedo.demo.data.remote.model.ClientsResponse
import javax.inject.Inject

/****
 * Project: Bottom Navigation Bar Compose
 * From: com.asalcedo.demo.data.remote.client
 * Created by Alex Salcedo Silva on 22/1/24 at 19:28
 * All rights reserve 2022.
 ***/
class ClientRemoteDataSourceImpl @Inject constructor(private val apiService: ClientApiService) :
    ClientRemoteDataSource {
    override suspend fun getClients(token: String): ClientsResponse? {
        runCatching { apiService.getClients(token = token) }
            .onSuccess { return it }
            .onFailure { Log.i("Demo App", "An error has ocurred: ${it.message} ") }
        return null
    }
}