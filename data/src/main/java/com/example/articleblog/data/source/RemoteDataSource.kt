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
    
    suspend fun loginUser(loginRequest: LoginRequest): String {
        val tokenResponse = api.loginUser(loginRequest)
        return tokenResponse.body()?.token ?: tokenResponse.message()
    }
    
    suspend fun registerUser(registerRequest: RegisterRequest): String {
        val tokenResponse = api.registerUser(registerRequest)
        return tokenResponse.body()?.token ?: tokenResponse.message()
    }
    
    suspend fun getAllCategories(): List<CategoryResponse> {
        val categoryResponse = api.getAllCategories()
        return if (categoryResponse.isSuccessful) {
            Log.d("response", categoryResponse.body().toString())
            categoryResponse.body() ?: emptyList()
        } else {
            Log.d("response", categoryResponse.errorBody().toString())
            emptyList()
        }
    }
    
    suspend fun publishArticle(articleRequest: WriteArticleRequest): String {
        return api.publishArticle(articleRequest).message()
    }
    
    suspend fun getLogin(tokenRequest: TokenRemote): String {
        val response = api.getLogin(tokenRequest)
        return response.body()?.login ?: response.message()
    }
}