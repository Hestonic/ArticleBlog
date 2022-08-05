package com.example.articleblog.domain.usecase

import com.example.articleblog.domain.model.LoginDTO
import com.example.articleblog.domain.model.TokenDTO
import com.example.articleblog.domain.repository.AuthorizationRepository

class LoginUserUseCase(private val authorizationRepository: AuthorizationRepository) {
    suspend fun loginUser(loginDTO: LoginDTO): TokenDTO {
        return authorizationRepository.loginUser(loginDTO)
    }
}