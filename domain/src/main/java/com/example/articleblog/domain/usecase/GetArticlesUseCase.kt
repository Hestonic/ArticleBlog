package com.example.articleblog.domain.usecase

import com.example.articleblog.domain.model.ArticlesDTO
import com.example.articleblog.domain.repository.ArticlesRepository

class GetArticlesUseCase(private val articlesRepository: ArticlesRepository) {
    suspend fun getArticles(): ArticlesDTO? {
        return articlesRepository.getArticles()
    }
}