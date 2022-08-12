package com.example.articleblog.domain.model

data class WriteArticleDTO(
    val title: String,
    val text: String,
    val categories: List<Int>,
)