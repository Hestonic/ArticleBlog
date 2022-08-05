package com.example.articleblog.data.repository

import com.example.articleblog.data.mapper.ArticlesMapper
import com.example.articleblog.data.source.RemoteDataSource
import com.example.articleblog.domain.model.ArticlesDTO
import com.example.articleblog.domain.repository.ArticlesRepository

class ArticlesRepositoryImpl(private val remoteDataSource: RemoteDataSource) : ArticlesRepository {
    
    override suspend fun getArticles(): ArticlesDTO? {
        remoteDataSource.getArticles()?.let { articlesResponse ->
            return ArticlesMapper.articlesResponseToDTO(articlesResponse)
        }
        return null
    }
}