package com.example.articleblog.data.source.remote.model

data class ArticlesResponse(
    val articlesList: List<ArticleResponse>,
)

data class ArticleResponse(
    val id: Int,
    val tittle: String,
    val text: String,
    val categories: List<CategoryResponse>,
    val articleInfo: ArticleInfoResponse,
)

data class CategoryResponse(
    val id: Int,
    val category: String,
)

data class ArticleInfoResponse(
    val id: Int,
    val likes: Int,
    val views: Int,
)