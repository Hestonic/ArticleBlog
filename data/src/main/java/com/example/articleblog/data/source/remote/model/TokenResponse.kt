package com.example.articleblog.data.source.remote.model

data class TokenResponse(
    val token: String,
    val isError: Boolean = false,
    val errorMessage: String? = "",
)