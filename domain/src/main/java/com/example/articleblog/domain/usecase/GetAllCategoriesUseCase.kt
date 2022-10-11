package com.example.articleblog.domain.usecase

import com.example.articleblog.domain.model.CategoryDTO
import com.example.articleblog.domain.repository.ArticlesRepository

class GetAllCategoriesUseCase(private val articlesRepository: ArticlesRepository) {
    suspend fun getAllCategories(): List<CategoryDTO> {
        return articlesRepository.getAllCategories()
    }
}