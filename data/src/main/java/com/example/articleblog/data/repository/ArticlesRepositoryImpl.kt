package com.example.articleblog.data.repository

import com.example.articleblog.data.source.RemoteDataSource
import com.example.articleblog.domain.repository.ArticlesRepository

class ArticlesRepositoryImpl(private val remoteDataSource: RemoteDataSource) : ArticlesRepository {
}