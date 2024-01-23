package com.asalcedo.demo.di

import android.content.Context
import com.asalcedo.demo.data.datastore.TokenDataStoreManager
import com.asalcedo.demo.data.remote.client.ClientApiService
import com.asalcedo.demo.data.remote.client.ClientRemoteDataSourceImpl
import com.asalcedo.demo.data.remote.client.ClientRepository
import com.asalcedo.demo.data.remote.client.ClientRepositoryImpl
import com.asalcedo.demo.data.remote.token.TokenApiService
import com.asalcedo.demo.data.remote.token.TokenRemoteDataSourceImpl
import com.asalcedo.demo.data.remote.token.TokenRepository
import com.asalcedo.demo.data.remote.token.TokenRepositoryImpl
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
        service: TokenRemoteDataSourceImpl,
        dataStoreManager: TokenDataStoreManager
    ): TokenRepository {
        return TokenRepositoryImpl(service, dataStoreManager)
    }

    @Singleton
    @Provides
    fun provideClientApiService(retrofit: Retrofit): ClientApiService {
        return retrofit.create(ClientApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideClientRepository(
        service: ClientRemoteDataSourceImpl,
        dataStoreManager: TokenDataStoreManager
    ): ClientRepository {
        return ClientRepositoryImpl(service, dataStoreManager)
    }

}