package com.example.articleblog.data.source.remote.model

data class ArticleRequest(
    val title: String,
    val text: String,
    val categories: List<Int>,
)