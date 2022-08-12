package com.example.articleblog.domain.model

data class ArticlesDTO(
    val articlesList: List<ArticleDTO>,
)

data class ArticleDTO(
    val id: Int,
    val title: String,
    val text: String,
    val categories: List<CategoryDTO>,
    val articleInfo: ArticleInfoDTO,
)

data class CategoryDTO(
    val id: Int,
    val category: String,
)

data class ArticleInfoDTO(
    val id: Int,
    val likes: Int,
    val views: Int,
)