package com.example.articleblog.domain.usecase

import com.example.articleblog.domain.repository.UserRepository

class GetLoginUseCase(private val userRepository: UserRepository) {
    suspend fun getLogin(token: String): String {
        return userRepository.getLogin(token)
    }
}