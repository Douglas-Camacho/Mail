package br.com.fiap.novomail.screens

import android.content.Context
import androidx.compose.ui.input.key.Key
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Extensão para simplificar o acesso ao DataStore
val Context.dataStore by preferencesDataStore(name = "user_preferences")

class UserPreferencesManager(private val context: Context) {

    companion object {
        val THEME_KEY = stringPreferencesKey("theme")
        val COLOR_KEY = stringPreferencesKey("color")
        val CATEGORY_KEY = stringPreferencesKey("category")

        const val THEME_LIGHT = "light"
        const val THEME_DARK = "dark"
    }


    // Função para salvar o tema
    suspend fun setTheme(theme: String) {
        context.dataStore.edit { preferences ->
            preferences[THEME_KEY] = theme
        }
    }

    // Função para obter o tema (retorna um Flow)
    val themeFlow: Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[THEME_KEY] ?: THEME_LIGHT
        }

    // Função para salvar a cor escolhida
    suspend fun setColor(color: String) {
        context.dataStore.edit { preferences ->
            preferences[COLOR_KEY] = color
        }
    }

    // Função para obter a cor (retorna um Flow)
    val colorFlow: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[COLOR_KEY] ?: "#FFFFFF" // branco padrão
        }

    // Função para salvar a categoria escolhida
    suspend fun setCategory(category: String) {
        context.dataStore.edit { preferences ->
            preferences[CATEGORY_KEY] = category
        }
    }

    // Função para obter a categoria (retorna um Flow)
    val categoryFlow: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[CATEGORY_KEY] ?: "default"
        }
}
