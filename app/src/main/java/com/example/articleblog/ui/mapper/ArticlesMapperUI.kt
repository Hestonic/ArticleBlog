package com.example.articleblog.ui.mapper

import com.example.articleblog.domain.model.ArticlesDTO
import com.example.articleblog.ui.model.ArticleInfoUiModel
import com.example.articleblog.ui.model.ArticleUiModel
import com.example.articleblog.ui.model.ArticlesUiModel
import com.example.articleblog.ui.model.CategoryUiModel

object ArticlesMapperUI {
    fun articlesDtoToArticlesUiModel(articlesDTO: ArticlesDTO): ArticlesUiModel {
        val articlesList = articlesDTO.articlesList.map { articleDTO ->
            ArticleUiModel(
                id = articleDTO.id,
                tittle = articleDTO.tittle,
                text = articleDTO.text,
                categories = articleDTO.categories.map { categoryDTO ->
                    CategoryUiModel(id = categoryDTO.id, categoryDTO.category)
                },
                articleInfo = ArticleInfoUiModel(
                    id = articleDTO.articleInfo.id,
                    likes = articleDTO.articleInfo.likes.toString(),
                    views = articleDTO.articleInfo.views.toString()
                ),
            )
        }
        return ArticlesUiModel(articlesList)
    }
}