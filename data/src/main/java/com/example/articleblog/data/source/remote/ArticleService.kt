package com.example.articleblog.data.source.remote

import com.example.articleblog.data.source.remote.model.ArticlesResponse
import com.example.articleblog.data.source.remote.model.LoginRequest
import com.example.articleblog.data.source.remote.model.RegisterRequest
import com.example.articleblog.data.source.remote.model.TokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ArticleService {
    @GET("/api/articles")
    suspend fun getArticles(): Response<ArticlesResponse>
    
    @POST("/api/login")
    suspend fun loginUser(@Body request: LoginRequest): Response<TokenResponse>
    
    @POST("/api/register")
    suspend fun registerUser(@Body request: RegisterRequest): Response<TokenResponse>
}