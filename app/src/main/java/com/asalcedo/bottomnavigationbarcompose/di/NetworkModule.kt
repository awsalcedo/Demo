package com.asalcedo.bottomnavigationbarcompose.di

import com.asalcedo.bottomnavigationbarcompose.data.remote.ApiGpsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    @Named("BaseUrl")
    fun provideBaseUrl() = "https://api.service24gps.com/api/v1"

    @Singleton
    @Provides
    fun provideRetrofit(@Named("BaseUrl") baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiGpsService(retrofit: Retrofit): ApiGpsService {
        return retrofit.create(ApiGpsService::class.java)
    }
}