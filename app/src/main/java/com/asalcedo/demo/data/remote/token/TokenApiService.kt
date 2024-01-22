package com.asalcedo.demo.data.remote.token

import com.asalcedo.demo.data.datastore.TokenDataStoreManager
import com.asalcedo.demo.data.remote.model.ClientsResponse
import com.asalcedo.demo.data.remote.model.TokenResponse
import com.asalcedo.demo.util.Constants
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface TokenApiService {
    @FormUrlEncoded
    @POST("gettoken")
    suspend fun getToken(
        @Field("apikey") apikey: String = Constants.API_KEY,
        @Field("token") token: String? = "",
        @Field("username") username: String,
        @Field("password") password: String
    ): TokenResponse

    @FormUrlEncoded
    @POST("getClients")
    suspend fun getClients(
        @Field("apikey") apikey: String = Constants.API_KEY,
        @Field("token") token: String
    ): ClientsResponse
}