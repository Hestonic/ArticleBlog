package com.example.articleblog.domain.usecase

import com.example.articleblog.domain.model.RegisterDTO
import com.example.articleblog.domain.repository.AuthorizationRepository

class RegisterUserUseCase(private val authorizationRepository: AuthorizationRepository) {
    suspend fun registerUser(registerDTO: RegisterDTO): String {
        return authorizationRepository.registerUser(registerDTO)
    }
}