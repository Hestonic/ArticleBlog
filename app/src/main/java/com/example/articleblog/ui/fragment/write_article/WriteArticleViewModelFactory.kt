package com.example.articleblog.ui.fragment.write_article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.articleblog.domain.usecase.GetAllCategoriesUseCase

class WriteArticleViewModelFactory(private val getAllCategoriesUseCase: GetAllCategoriesUseCase) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WriteArticleViewModel::class.java))
            return WriteArticleViewModel(getAllCategoriesUseCase) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}