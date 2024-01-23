package com.asalcedo.demo.data.remote.client

import com.asalcedo.demo.data.remote.model.ClientsResponse
import com.asalcedo.demo.data.remote.model.ServerClient

/****
 * Project: Bottom Navigation Bar Compose
 * From: com.asalcedo.demo.data.remote.client
 * Created by Alex Salcedo Silva on 22/1/24 at 19:25
 * All rights reserve 2022.
 ***/
interface ClientRemoteDataSource {
    suspend fun getClients(token: String): ClientsResponse?
}