package com.example.articleblog.ui.fragment.articles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.articleblog.domain.usecase.GetArticlesUseCase
import com.example.articleblog.ui.mapper.ArticlesMapperUI
import com.example.articleblog.ui.model.ArticlesUiModel
import kotlinx.coroutines.launch

class ArticlesViewModel(private val getArticlesUseCase: GetArticlesUseCase) : ViewModel() {
    
    private val _articlesLiveData: MutableLiveData<ArticlesUiModel> = MutableLiveData()
    val articlesLiveData: LiveData<ArticlesUiModel> get() = _articlesLiveData
    
    fun getArticles() {
        viewModelScope.launch {
            getArticlesUseCase.getArticles()?.let { articlesDTO ->
                val articlesUiModel = ArticlesMapperUI.articlesDtoToArticlesUiModel(articlesDTO)
                _articlesLiveData.postValue(articlesUiModel)
            }
        }
    }
}