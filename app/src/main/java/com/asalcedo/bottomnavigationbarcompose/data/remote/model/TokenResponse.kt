package com.asalcedo.bottomnavigationbarcompose.data.remote.model

import com.asalcedo.bottomnavigationbarcompose.domain.model.ApiGpsModel
import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("data")
    val data: String,
    @SerializedName("status")
    val status: Int
)

fun TokenResponse.toDomain(): ApiGpsModel {
    return ApiGpsModel(
        token = data,
        status = status
    )
}