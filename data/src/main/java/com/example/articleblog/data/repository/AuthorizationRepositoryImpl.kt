package com.example.articleblog.data.repository

import com.example.articleblog.data.source.RemoteDataSource
import com.example.articleblog.domain.repository.AuthorizationRepository

class AuthorizationRepositoryImpl(private val remoteDataSource: RemoteDataSource) : AuthorizationRepository {
}