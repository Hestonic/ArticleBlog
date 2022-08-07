package com.example.articleblog.domain.usecase

import com.example.articleblog.domain.model.ArticleDTO
import com.example.articleblog.domain.repository.ArticlesRepository

class GetArticleByIdUseCase(private val articlesRepository: ArticlesRepository) {
    suspend fun getArticleById(id: String): ArticleDTO? {
        return articlesRepository.getArticleById(id)
    }
}