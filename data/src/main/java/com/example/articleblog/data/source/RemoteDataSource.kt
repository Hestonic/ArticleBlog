package com.example.articleblog.data.source

import android.util.Log
import com.example.articleblog.data.source.remote.ArticleService
import com.example.articleblog.data.source.remote.model.ArticlesResponse
import com.example.articleblog.data.source.remote.model.LoginRequest
import com.example.articleblog.data.source.remote.model.RegisterRequest

class RemoteDataSource(private val api: ArticleService) {
    
    suspend fun getArticles(): ArticlesResponse? {
        val articlesResponse = api.getArticles()
        return if (articlesResponse.isSuccessful) {
            Log.d("response", articlesResponse.body().toString())
            articlesResponse.body()
        } else {
            Log.d("response", articlesResponse.errorBody().toString())
            null
        }
    }
    
    suspend fun loginUser(loginRequest: LoginRequest): String {
        val userToken = api.loginUser(loginRequest)
        return if (userToken.isSuccessful) {
            Log.d("response", userToken.body().toString())
            userToken.body() ?: ""
        } else {
            Log.d("response", userToken.errorBody().toString())
            ""
        }
    }
    
    suspend fun registerUser(registerRequest: RegisterRequest): String {
        val userToken = api.registerUser(registerRequest)
        return if (userToken.isSuccessful) {
            Log.d("response", userToken.body().toString())
            userToken.body() ?: ""
        } else {
            Log.d("response", userToken.errorBody().toString())
            ""
        }
    }
}