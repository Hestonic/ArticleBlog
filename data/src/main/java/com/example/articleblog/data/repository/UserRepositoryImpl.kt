package com.example.articleblog.data.repository

import com.example.articleblog.data.source.RemoteDataSource
import com.example.articleblog.data.source.remote.model.TokenRemote
import com.example.articleblog.domain.repository.UserRepository

class UserRepositoryImpl(private val remoteDataSource: RemoteDataSource) : UserRepository {
    override suspend fun getLogin(token: String): String {
        return remoteDataSource.getLogin(TokenRemote(token = token))
    }
}