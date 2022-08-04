package com.example.articleblog.data.repository

import com.example.articleblog.data.source.RemoteDataSource
import com.example.articleblog.domain.model.ArticleDTO
import com.example.articleblog.domain.model.ArticleInfoDTO
import com.example.articleblog.domain.model.ArticlesDTO
import com.example.articleblog.domain.model.CategoryDTO
import com.example.articleblog.domain.repository.ArticlesRepository

class ArticlesRepositoryImpl(private val remoteDataSource: RemoteDataSource) : ArticlesRepository {
    override suspend fun getArticles(): ArticlesDTO? {
        remoteDataSource.getArticles()?.let { articlesResponse ->
            val articlesList = articlesResponse.articlesList.map { articleResponse ->
                ArticleDTO(
                    id = articleResponse.id,
                    tittle = articleResponse.tittle,
                    text = articleResponse.text,
                    categories = articleResponse.categories.map { categoryResponse ->
                        CategoryDTO(id = categoryResponse.id, category = categoryResponse.category)
                    },
                    articleInfo = ArticleInfoDTO(
                        id = articleResponse.articleInfo.id,
                        likes = articleResponse.articleInfo.likes,
                        views = articleResponse.articleInfo.views
                    ),
                )
            }
            return ArticlesDTO(articlesList = articlesList)
        }
        return null
    }
}