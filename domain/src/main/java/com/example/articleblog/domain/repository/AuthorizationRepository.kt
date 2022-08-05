package com.example.articleblog.domain.repository

import com.example.articleblog.domain.model.LoginDTO

interface AuthorizationRepository {
    suspend fun loginUser(loginDTO: LoginDTO): String
    suspend fun registerUser(registerDTO: LoginDTO): String
}