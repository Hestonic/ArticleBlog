package com.example.articleblog.ui.model

data class ArticlesUiModel(
    val articlesList: List<ArticleUiModel>,
)

data class ArticleUiModel(
    val id: Int,
    val title: String,
    val text: String,
    val categories: List<CategoryUiModel>,
    val articleInfo: ArticleInfoUiModel,
    val author: String,
)

data class CategoryUiModel(
    val id: Int,
    val category: String,
)

data class ArticleInfoUiModel(
    val id: Int,
    val likes: String,
    val views: String,
)