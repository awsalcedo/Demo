package com.asalcedo.demo.data.remote.model

import com.google.gson.annotations.SerializedName

data class ClientsResponse(
    @SerializedName("data")
    val data: List<ServerClient>,
    @SerializedName("status")
    val status: Int
)