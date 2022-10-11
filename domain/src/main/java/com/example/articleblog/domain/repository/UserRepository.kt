package com.example.articleblog.domain.repository

interface UserRepository {
    suspend fun getLogin(token: String): String
}