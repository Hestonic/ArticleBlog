package com.example.articleblog.data.source.remote.model

data class ArticlesResponse(
    val articlesList: List<ArticleResponse>,
)

data class ArticleResponse(
    val id: Int,
    val tittle: String,
    val text: String,
    val categories: List<Category>,
    val articleInfo: ArticleInfo,
)

data class Category(
    val id: Int,
    val category: String,
)

data class ArticleInfo(
    val id: Int,
    val likes: Int,
    val views: Int,
)