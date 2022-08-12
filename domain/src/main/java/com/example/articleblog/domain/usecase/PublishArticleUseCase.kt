package com.example.articleblog.domain.usecase

import com.example.articleblog.domain.model.WriteArticleDTO
import com.example.articleblog.domain.repository.ArticlesRepository

class PublishArticleUseCase(private val articlesRepository: ArticlesRepository) {
    suspend fun publishArticle(writeArticleDTO: WriteArticleDTO): String {
        return articlesRepository.publishArticle(writeArticleDTO)
    }
}