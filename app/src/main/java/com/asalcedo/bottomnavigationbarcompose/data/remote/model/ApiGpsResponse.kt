package com.asalcedo.bottomnavigationbarcompose.data.remote.model

import com.asalcedo.bottomnavigationbarcompose.domain.model.ApiGpsModel
import com.google.gson.annotations.SerializedName

data class ApiGpsResponse(
    @SerializedName("data")
    val data: String,
    @SerializedName("status")
    val status: Int
)

fun ApiGpsResponse.toDomain(): ApiGpsModel {
    return ApiGpsModel(
        token = data,
        status = status
    )
}