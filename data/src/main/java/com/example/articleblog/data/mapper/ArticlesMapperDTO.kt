package com.example.articleblog.data.mapper

import com.example.articleblog.data.source.remote.model.ArticlesResponse
import com.example.articleblog.data.source.remote.model.LoginRequest
import com.example.articleblog.data.source.remote.model.RegisterRequest
import com.example.articleblog.domain.model.*

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
    
    fun loginDtoToRequest(loginDTO: LoginDTO) =
        LoginRequest(login = loginDTO.login, password = loginDTO.password)
    
    fun registerDtoToRequest(registerDTO: RegisterDTO) =
        RegisterRequest(login =registerDTO.login, password =registerDTO.password)
}