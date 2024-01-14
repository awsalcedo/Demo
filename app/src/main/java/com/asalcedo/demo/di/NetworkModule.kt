package com.asalcedo.demo.di

import android.content.Context
import com.asalcedo.demo.data.datastore.TokenDataStoreManager
import com.asalcedo.demo.data.remote.TokenApiService
import com.asalcedo.demo.data.remote.TokenRepository
import com.asalcedo.demo.data.remote.TokenRepositoryImpl
import com.asalcedo.demo.data.remote.TokenService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideBaseUrl() = "https://api.service24gps.com/api/v1/"

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
    fun provideApiGpsService(retrofit: Retrofit): TokenApiService {
        return retrofit.create(TokenApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideTokenDataStoreManager(@ApplicationContext context: Context): TokenDataStoreManager {
        return TokenDataStoreManager(context)
    }

    @Singleton
    @Provides
    fun provideTokenRepository(
        service: TokenService,
        dataStoreManager: TokenDataStoreManager
    ): TokenRepository {
        return TokenRepositoryImpl(service, dataStoreManager)
    }

}