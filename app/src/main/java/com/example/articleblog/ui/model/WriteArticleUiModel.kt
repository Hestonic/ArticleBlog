package com.example.articleblog.ui.model

data class WriteArticleUiModel(
    val title: String,
    val text: String,
    val categories: List<Int>,
)
