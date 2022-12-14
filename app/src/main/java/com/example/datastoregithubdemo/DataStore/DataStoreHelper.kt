package com.example.datastoregithubdemo.DataStore

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore

const val USER_PREFERENCES_NAME = "data_store_preferences"

//extension for data store
val Context.myDataStore by preferencesDataStore(
    name = USER_PREFERENCES_NAME
)

object PreferenceKeys {
    val MY_STRING = stringPreferencesKey("my_string")
    val MY_BOOLEAN = booleanPreferencesKey("my_boolean")
    val MY_INT = intPreferencesKey("my_int")
    val MY_LONG = longPreferencesKey("my_long")
    val MY_FLOAT = floatPreferencesKey("my_float")
}