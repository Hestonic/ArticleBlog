package com.example.articleblog.ui.mapper

import com.example.articleblog.domain.model.ArticleDTO
import com.example.articleblog.domain.model.ArticlesDTO
import com.example.articleblog.domain.model.CategoryDTO
import com.example.articleblog.domain.model.WriteArticleDTO
import com.example.articleblog.ui.model.*

object ArticlesMapperUI {
    fun articlesDtoToArticlesUiModel(articlesDTO: ArticlesDTO): ArticlesUiModel {
        val articlesList = articlesDTO.articlesList.map { articleDTO ->
            articleDtoToArticleUiModel(articleDTO)
        }
        return ArticlesUiModel(articlesList)
    }
    
    fun articleDtoToArticleUiModel(articleDTO: ArticleDTO) = ArticleUiModel(
        id = articleDTO.id,
        title = articleDTO.title,
        text = articleDTO.text,
        categories = listCategoriesDtoToUiModel(articleDTO.categories),
        articleInfo = ArticleInfoUiModel(
            id = articleDTO.articleInfo.id,
            likes = articleDTO.articleInfo.likes.toString(),
            views = articleDTO.articleInfo.views.toString()
        ),
    )
    
    fun listCategoriesDtoToUiModel(listCategoriesDTO: List<CategoryDTO>) =
        listCategoriesDTO.map { CategoryUiModel(id = it.id, category = it.category) }
    
    fun mapWriteArticleUiModel(
        title: String, text: String, idsOfSelectedCategories: List<Int>
    ) = WriteArticleUiModel(title = title, text = text, categories = idsOfSelectedCategories)
    
    fun writeArticleUiModelToDTO(writeArticleUiModel: WriteArticleUiModel) =
        WriteArticleDTO(
            title = writeArticleUiModel.title,
            text = writeArticleUiModel.text,
            categories = writeArticleUiModel.categories
        )
    
    
}