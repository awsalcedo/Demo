package com.asalcedo.demo.data.remote.model

import com.asalcedo.demo.domain.model.TokenModel
import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("data")
    val data: String,
    @SerializedName("status")
    val status: Int
)

fun TokenResponse.toDomain(): TokenModel {
    return TokenModel(
        token = data,
        status = status
    )
}