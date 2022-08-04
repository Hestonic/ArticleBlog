package com.example.articleblog.ui.fragment.articles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.articleblog.domain.usecase.GetArticlesUseCase
import com.example.articleblog.ui.model.ArticleInfoUiModel
import com.example.articleblog.ui.model.ArticleUiModel
import com.example.articleblog.ui.model.ArticlesUiModel
import com.example.articleblog.ui.model.CategoryUiModel
import kotlinx.coroutines.launch

class ArticlesViewModel(private val getArticlesUseCase: GetArticlesUseCase) : ViewModel() {
    

}