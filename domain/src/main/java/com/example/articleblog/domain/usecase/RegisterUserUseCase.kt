package com.example.articleblog.domain.usecase

import com.example.articleblog.domain.model.RegisterDTO
import com.example.articleblog.domain.model.TokenDTO
import com.example.articleblog.domain.repository.AuthorizationRepository

class RegisterUserUseCase(private val authorizationRepository: AuthorizationRepository) {
    suspend fun registerUser(registerDTO: RegisterDTO): TokenDTO {
        return authorizationRepository.registerUser(registerDTO)
    }
}