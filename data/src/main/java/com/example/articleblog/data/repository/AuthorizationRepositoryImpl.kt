package com.example.articleblog.data.repository

import com.example.articleblog.data.mapper.AuthorizationMapperDTO
import com.example.articleblog.data.source.RemoteDataSource
import com.example.articleblog.domain.model.LoginDTO
import com.example.articleblog.domain.model.RegisterDTO
import com.example.articleblog.domain.repository.AuthorizationRepository

class AuthorizationRepositoryImpl(private val remoteDataSource: RemoteDataSource) : AuthorizationRepository {
    
    override suspend fun loginUser(loginDTO: LoginDTO): String {
        val loginRequest = AuthorizationMapperDTO.loginDtoToRequest(loginDTO)
        return remoteDataSource.loginUser(loginRequest)
    }
    
    override suspend fun registerUser(registerDTO: RegisterDTO): String {
        val registerRequest = AuthorizationMapperDTO.registerDtoToRequest(registerDTO)
        return remoteDataSource.registerUser(registerRequest)
    }
}