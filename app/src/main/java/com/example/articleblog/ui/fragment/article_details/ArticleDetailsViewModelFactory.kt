package com.example.articleblog.ui.fragment.article_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.articleblog.domain.usecase.GetArticleByIdUseCase

class ArticleDetailsViewModelFactory(val getArticleByIdUseCase: GetArticleByIdUseCase) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArticleDetailsViewModel::class.java))
            return ArticleDetailsViewModel(getArticleByIdUseCase) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}