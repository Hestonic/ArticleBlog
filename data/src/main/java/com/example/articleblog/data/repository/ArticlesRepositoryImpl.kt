package com.example.articleblog.data.repository

import com.example.articleblog.data.mapper.ArticlesMapperDTO
import com.example.articleblog.data.source.RemoteDataSource
import com.example.articleblog.domain.model.ArticleDTO
import com.example.articleblog.domain.model.ArticlesDTO
import com.example.articleblog.domain.model.CategoryDTO
import com.example.articleblog.domain.repository.ArticlesRepository

class ArticlesRepositoryImpl(private val remoteDataSource: RemoteDataSource) : ArticlesRepository {
    
    override suspend fun getArticles(): ArticlesDTO? {
        remoteDataSource.getArticles()?.let { articlesResponse ->
            return ArticlesMapperDTO.articlesResponseToDTO(articlesResponse)
        }
        return null
    }
    
    override suspend fun getArticleById(id: String): ArticleDTO? {
        remoteDataSource.getArticleById(id)?.let { articleResponse ->
            return ArticlesMapperDTO.articleResponseToDTO(articleResponse)
        }
        return null
    }
    
    override suspend fun getAllCategories(): List<CategoryDTO> {
        val categoryResponseList = remoteDataSource.getAllCategories()
        return ArticlesMapperDTO.categoryResponseListToDTO(categoryResponseList)
    }
}