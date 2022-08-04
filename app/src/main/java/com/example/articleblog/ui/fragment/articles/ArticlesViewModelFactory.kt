package com.example.articleblog.ui.fragment.articles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.articleblog.domain.usecase.GetArticlesUseCase

class ArticlesViewModelFactory(val getArticlesUseCase: GetArticlesUseCase) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArticlesViewModel::class.java))
            return ArticlesViewModel(getArticlesUseCase) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}