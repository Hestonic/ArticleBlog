package com.example.articleblog.data.mapper

import com.example.articleblog.data.source.remote.model.ArticleRequest
import com.example.articleblog.data.source.remote.model.ArticleResponse
import com.example.articleblog.data.source.remote.model.ArticlesResponse
import com.example.articleblog.data.source.remote.model.CategoryResponse
import com.example.articleblog.domain.model.*

object ArticlesMapperDTO {
    
    fun articlesResponseToDTO(articlesResponse: ArticlesResponse) : ArticlesDTO {
        val articlesList = articlesResponse.articlesList.map { articleResponse ->
            articleResponseToDTO(articleResponse)
        }
        return ArticlesDTO(articlesList = articlesList)
    }
    
    fun articleResponseToDTO(articleResponse: ArticleResponse) =
        ArticleDTO(
            id = articleResponse.id,
            title = articleResponse.title,
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
    
    fun categoryResponseListToDTO(categoryResponseList: List<CategoryResponse>) =
        categoryResponseList.map { CategoryDTO(id = it.id, category = it.category) }
    
    fun writeArticleDtoToRequest(writeArticleDTO: WriteArticleDTO) =
        ArticleRequest(
            title = writeArticleDTO.title,
            text = writeArticleDTO.text,
            categories = writeArticleDTO.categories,
        )
    
}