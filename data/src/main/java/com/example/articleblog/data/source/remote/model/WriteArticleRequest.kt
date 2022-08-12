package com.example.articleblog.data.source.remote.model

data class WriteArticleRequest(
    val title: String,
    val text: String,
    val categories: List<Int>,
    val author: String,
)