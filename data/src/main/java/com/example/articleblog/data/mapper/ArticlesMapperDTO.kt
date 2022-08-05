package com.example.articleblog.data.mapper

import com.example.articleblog.data.source.remote.model.ArticlesResponse
import com.example.articleblog.domain.model.ArticleDTO
import com.example.articleblog.domain.model.ArticleInfoDTO
import com.example.articleblog.domain.model.ArticlesDTO
import com.example.articleblog.domain.model.CategoryDTO

object ArticlesMapperDTO {
    
    fun articlesResponseToDTO(articlesResponse: ArticlesResponse) : ArticlesDTO {
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
}