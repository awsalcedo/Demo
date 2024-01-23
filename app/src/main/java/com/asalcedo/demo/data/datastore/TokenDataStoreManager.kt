package com.asalcedo.demo.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.asalcedo.demo.domain.model.ClientModel
import com.asalcedo.demo.util.Constants
import com.google.gson.Gson
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
private val Context.tokenDataStore by preferencesDataStore(name = Constants.DATASTORE_PREFERENCES_NAME)

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

    suspend fun saveClients(clientModels: List<ClientModel>) {
        dataStore.edit { preferences ->
            // Guardar la lista de clientes serializada en JSON en el DataStore
            preferences[DataStoreKeys.CLIENTS_KEY] = Gson().toJson(clientModels)
        }
    }

}
