package com.asalcedo.demo.data.remote.client

import com.asalcedo.demo.data.remote.model.ClientsResponse
import com.asalcedo.demo.domain.model.ClientModel

/****
 * Project: Bottom Navigation Bar Compose
 * From: com.asalcedo.demo.data.remote.client
 * Created by Alex Salcedo Silva on 22/1/24 at 22:11
 * All rights reserve 2022.
 ***/
interface ClientRepository {
    suspend fun getClients(): List<ClientModel>
}