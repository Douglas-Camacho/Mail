package br.com.fiap.novomail

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.io.IOException

private val Context.emailsDataStore: DataStore<Preferences> by preferencesDataStore(name = "emails")

class EmailFavorito(context: Context) {

    private val dataStore = context.emailsDataStore

    companion object {
        private val EMAIL_FAVORITE_KEY = booleanPreferencesKey("email_favorite")
    }

    suspend fun setEmailFavorite(emailId: Int, isFavorite: Boolean) {
        withContext(Dispatchers.IO) {
            dataStore.edit { preferences ->
                val emailKey = booleanPreferencesKey("email_$emailId")
                preferences[emailKey] = isFavorite
            }
        }
    }
    fun isEmailFavorite(emailId: Int): Flow<Boolean> {
        val emailKey = booleanPreferencesKey("email_$emailId")
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                preferences[emailKey] ?: false
            }
    }
}