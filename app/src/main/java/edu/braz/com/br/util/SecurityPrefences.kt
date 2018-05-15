package edu.braz.com.br.util


import android.content.Context

class SecurityPrefences(val context: Context) {

     private val mSharedPreferences = context.getSharedPreferences("FimDeAno", Context.MODE_PRIVATE)

    fun storeString(key: String, value: String) {
        this.mSharedPreferences.edit().putString(key, value).apply()
    }

    fun getStoredString(key: String): String {
        return this.mSharedPreferences.getString(key, "")
    }
}