package com.example.articleblog.domain.repository

import com.example.articleblog.domain.model.LoginDTO
import com.example.articleblog.domain.model.RegisterDTO

interface AuthorizationRepository {
    suspend fun loginUser(loginDTO: LoginDTO): String
    suspend fun registerUser(registerDTO: RegisterDTO): String
}