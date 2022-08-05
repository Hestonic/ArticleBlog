package com.example.articleblog.data.repository

import com.example.articleblog.data.mapper.AuthorizationMapperDTO
import com.example.articleblog.data.source.RemoteDataSource
import com.example.articleblog.domain.model.LoginDTO
import com.example.articleblog.domain.model.RegisterDTO
import com.example.articleblog.domain.model.TokenDTO
import com.example.articleblog.domain.repository.AuthorizationRepository

class AuthorizationRepositoryImpl(private val remoteDataSource: RemoteDataSource) : AuthorizationRepository {
    
    override suspend fun loginUser(loginDTO: LoginDTO): TokenDTO {
        val loginRequest = AuthorizationMapperDTO.loginDtoToRequest(loginDTO)
        val tokenResponse = remoteDataSource.loginUser(loginRequest)
        return AuthorizationMapperDTO.tokenResponseToDTO(tokenResponse)
    }
    
    override suspend fun registerUser(registerDTO: RegisterDTO): TokenDTO {
        val registerRequest = AuthorizationMapperDTO.registerDtoToRequest(registerDTO)
        val tokenResponse = remoteDataSource.registerUser(registerRequest)
        return AuthorizationMapperDTO.tokenResponseToDTO(tokenResponse)
    }
}