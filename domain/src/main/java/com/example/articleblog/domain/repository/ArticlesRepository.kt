package com.example.articleblog.domain.repository

import com.example.articleblog.domain.model.ArticlesDTO

interface ArticlesRepository {
    suspend fun getArticles(): ArticlesDTO?
}