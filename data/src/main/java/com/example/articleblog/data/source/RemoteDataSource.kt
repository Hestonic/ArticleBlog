package com.example.articleblog.data.source

import android.util.Log
import com.example.articleblog.data.source.remote.ArticleService
import com.example.articleblog.data.source.remote.model.*

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
    
    suspend fun getArticleById(id: String): ArticleResponse? {
        val articleResponse = api.getArticleById(id)
        return if (articleResponse.isSuccessful) {
            Log.d("response", articleResponse.body().toString())
            articleResponse.body()
        } else {
            Log.d("response", articleResponse.errorBody().toString())
            null
        }
    }
    
    suspend fun loginUser(loginRequest: LoginRequest): TokenResponse {
        val tokenResponse = api.loginUser(loginRequest)
        return if (tokenResponse.isSuccessful) {
            Log.d("response", tokenResponse.body().toString())
            tokenResponse.body()!!
        } else {
            Log.d("response", tokenResponse.message())
            TokenResponse(
                token = "",
                isError = true,
                errorMessage = tokenResponse.message()
            )
        }
    }
    
    suspend fun registerUser(registerRequest: RegisterRequest): TokenResponse {
        val tokenResponse = api.registerUser(registerRequest)
        return if (tokenResponse.isSuccessful) {
            Log.d("response", tokenResponse.body().toString())
            tokenResponse.body()!!
        } else {
            Log.d("response", tokenResponse.errorBody().toString())
            TokenResponse(
                token = "",
                isError = true,
                errorMessage = tokenResponse.message()
            )
        }
    }
}