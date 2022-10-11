package com.example.articleblog.data.source.remote

import com.example.articleblog.data.source.remote.model.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ArticleService {
    @GET("/api/articles")
    suspend fun getArticles(): Response<ArticlesResponse>
    
    @GET("/api/articles/{id}")
    suspend fun getArticleById(@Path("id") id: String): Response<ArticleResponse>
    
    @GET("/api/categories")
    suspend fun getAllCategories(): Response<List<CategoryResponse>>
    
    @POST("/api/login")
    suspend fun loginUser(@Body request: LoginRequest): Response<TokenRemote>
    
    @POST("/api/register")
    suspend fun registerUser(@Body request: RegisterRequest): Response<TokenRemote>
    
    @POST("/api/articles/add")
    suspend fun publishArticle(@Body request: WriteArticleRequest): Response<Void>
    
    @POST("/api/session")
    suspend fun getLogin(@Body request: TokenRemote): Response<LoginResponse>
}