package com.example.articleblog.data.source.remote.model

data class LoginRequest(
    val login: String,
    val password: String,
)

data class LoginResponse(
    val login: String,
)