package com.example.articleblog.data.source.remote.model

data class ArticlesResponse(
    val articlesList: List<ArticleResponse>,
)

data class ArticleResponse(
    val id: Int,
    val title: String,
    val text: String,
    val categories: List<CategoryResponse>,
    val articleInfo: ArticleInfoResponse,
    val author: String,
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