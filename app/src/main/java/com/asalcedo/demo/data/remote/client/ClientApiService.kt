package com.asalcedo.demo.data.remote.client

import com.asalcedo.demo.data.remote.model.ClientsResponse
import com.asalcedo.demo.util.Constants
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/****
 * Project: Bottom Navigation Bar Compose
 * From: com.asalcedo.demo.data.remote.client
 * Created by Alex Salcedo Silva on 22/1/24 at 19:19
 * All rights reserve 2022.
 ***/
interface ClientApiService {
    @FormUrlEncoded

    @POST("getClients")
    suspend fun getClients(
        @Field("apikey") apikey: String = Constants.API_KEY,
        @Field("token") token: String
    ): ClientsResponse
}