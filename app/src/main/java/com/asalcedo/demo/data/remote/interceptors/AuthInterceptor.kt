package com.asalcedo.demo.data.remote.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val apikey: String, private val token: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val newRequest = original.newBuilder()
            .header("Content-Type", "application/json")
            .header("apikey", apikey)
            .header("token", token)
            .method(original.method, original.body)
            .build()

        return chain.proceed(newRequest)
    }
}

class TokenManager {
    fun getTokenDataBase(): String =
        "ES6gF3olgNfzRtKBt34bUknZPamrmauK+koiwBBMMG1IEQTclhKsJVodlbY3+Mtb"
}