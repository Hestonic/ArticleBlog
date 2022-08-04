package com.example.articleblog.data.source.remote

import com.example.articleblog.data.source.remote.model.ArticlesResponse
import retrofit2.Response
import retrofit2.http.GET

interface ArticleService {
    @GET("/api/articles")
    suspend fun getArticles(): Response<ArticlesResponse>
}