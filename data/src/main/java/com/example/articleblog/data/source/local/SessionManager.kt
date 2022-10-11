package com.example.articleblog.data.source.local

import android.content.Context
import android.content.SharedPreferences
import com.example.data.R

class SessionManager(context: Context) {
    private var prefs: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
    
    companion object {
        const val USER_TOKEN = "user_token"
    }
    
    fun saveAuthToken(token: String) {
        prefs.edit().putString(USER_TOKEN, token).apply()
    }
    
    fun getAuthToken(): String? = prefs.getString(USER_TOKEN, null)
    
    fun deleteAuthToken() {
        prefs.edit().putString(USER_TOKEN, null).apply()
    }
}