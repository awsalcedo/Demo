package com.asalcedo.demo.domain.usecase

import com.asalcedo.demo.data.remote.TokenRepository
import javax.inject.Inject

/****
 * Project: Bottom Navigation Bar Compose
 * From: com.asalcedo.demo.domain.usecase
 * Created by Alex Salcedo Silva on 10/1/24 at 16:20
 * All rights reserve 2022.
 ***/
class GetTokenUseCase @Inject constructor(private val repository: TokenRepository) {
    suspend operator fun invoke(user: String, password: String) =
        repository.getTokenApi(user, password)
}