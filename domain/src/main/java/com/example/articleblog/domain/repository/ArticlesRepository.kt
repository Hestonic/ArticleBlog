package com.example.articleblog.domain.repository

import com.example.articleblog.domain.model.ArticleDTO
import com.example.articleblog.domain.model.ArticlesDTO
import com.example.articleblog.domain.model.CategoryDTO
import com.example.articleblog.domain.model.WriteArticleDTO

interface ArticlesRepository {
    suspend fun getArticles(): ArticlesDTO?
    suspend fun getArticleById(id: String): ArticleDTO?
    suspend fun getAllCategories(): List<CategoryDTO>
    suspend fun publishArticle(writeArticleDTO: WriteArticleDTO): String
}