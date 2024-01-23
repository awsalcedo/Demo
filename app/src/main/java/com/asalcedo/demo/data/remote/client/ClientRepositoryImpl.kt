package com.asalcedo.demo.data.remote.client

import android.util.Log
import com.asalcedo.demo.data.datastore.TokenDataStoreManager
import com.asalcedo.demo.data.remote.model.toDomain
import com.asalcedo.demo.domain.model.ClientModel
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

/****
 * Project: Bottom Navigation Bar Compose
 * From: com.asalcedo.demo.data.remote.client
 * Created by Alex Salcedo Silva on 22/1/24 at 22:14
 * All rights reserve 2022.
 ***/
class ClientRepositoryImpl @Inject constructor(
    private val clientRemoteDataSourceImpl: ClientRemoteDataSourceImpl,
    private val dataStoreManager: TokenDataStoreManager
) : ClientRepository {
    override suspend fun getClients(): List<ClientModel> {
        val token = dataStoreManager.getTokenFlow.firstOrNull() ?: return emptyList()
        Log.d("ALEX", "Token obtenido desde el DataStore: $token")

        val clientsResponse = clientRemoteDataSourceImpl.getClients(token)

        return if (clientsResponse != null && clientsResponse.status == 200 && clientsResponse.data.isNotEmpty()) {
            val clientModels = clientsResponse.data.map { it.toDomain() }

            // Guardar la información en el DataStore
            saveClientsToDataStore(clientModels)

            clientModels
        } else {
            emptyList()
        }
    }

    private suspend fun saveClientsToDataStore(clientModels: List<ClientModel>) {
        // Guardar la información en el DataStore
        dataStoreManager.saveClients(clientModels)
    }
}