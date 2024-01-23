package com.asalcedo.demo.domain.usecase

import com.asalcedo.demo.data.remote.client.ClientRepository
import com.asalcedo.demo.data.remote.exception.ClientsException
import com.asalcedo.demo.domain.model.ClientModel
import com.asalcedo.demo.util.ResponseState
import javax.inject.Inject

class GetClientsUseCase @Inject constructor(private val repository: ClientRepository) {
    suspend operator fun invoke(): ResponseState<List<ClientModel>> {
        return try {
            val result = repository.getClients()
            ResponseState.Success(result)
        } catch (e: ClientsException) {
            ResponseState.Error(e.message.toString())
        } catch (e: Exception) {
            ResponseState.Error(e.message.toString())

        }
    }

}