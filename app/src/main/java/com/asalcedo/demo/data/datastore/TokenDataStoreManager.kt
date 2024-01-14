package com.asalcedo.demo.data.datastore

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

/****
 * Project: Bottom Navigation Bar Compose
 * From: com.asalcedo.demo.data.datastore
 * Created by Alex Salcedo Silva on 11/1/24 at 19:48
 * All rights reserve 2022.
 ***/
// TokenDataStore.kt
private val Context.tokenDataStore by preferencesDataStore(name = "user_preferences")

class TokenDataStoreManager @Inject constructor(@ApplicationContext context: Context) {

    private val dataStore: DataStore<Preferences> = context.tokenDataStore

    suspend fun saveToken(token: String) {
        dataStore.edit { preferences ->
            preferences[DataStoreKeys.TOKEN_KEY] = token
        }
    }

    val getTokenFlow: Flow<String?> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            preferences[DataStoreKeys.TOKEN_KEY]
        }

}
