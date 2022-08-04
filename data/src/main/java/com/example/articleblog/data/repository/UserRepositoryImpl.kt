package com.example.articleblog.data.repository

import com.example.articleblog.data.source.RemoteDataSource
import com.example.articleblog.domain.repository.UserRepository

class UserRepositoryImpl(private val remoteDataSource: RemoteDataSource) : UserRepository {
}