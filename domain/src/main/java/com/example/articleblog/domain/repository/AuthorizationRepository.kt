package com.example.articleblog.domain.repository

import com.example.articleblog.domain.model.LoginDTO
import com.example.articleblog.domain.model.RegisterDTO
import com.example.articleblog.domain.model.TokenDTO

interface AuthorizationRepository {
    suspend fun loginUser(loginDTO: LoginDTO): TokenDTO
    suspend fun registerUser(registerDTO: RegisterDTO): TokenDTO
}