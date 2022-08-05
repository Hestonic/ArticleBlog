package com.example.articleblog.domain.model

data class TokenDTO(
    val token: String,
    val isError: Boolean,
    val errorMessage: String,
)
