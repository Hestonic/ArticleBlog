package com.example.articleblog.ui.fragment.write_article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.articleblog.domain.usecase.GetAllCategoriesUseCase
import com.example.articleblog.domain.usecase.PublishArticleUseCase

class WriteArticleViewModelFactory(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val publishArticleUseCase: PublishArticleUseCase
) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WriteArticleViewModel::class.java))
            return WriteArticleViewModel(getAllCategoriesUseCase, publishArticleUseCase) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}