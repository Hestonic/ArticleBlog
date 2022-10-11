package com.example.articleblog.ui.fragment.article_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.articleblog.domain.usecase.GetArticleByIdUseCase
import com.example.articleblog.ui.mapper.ArticlesMapperUI
import com.example.articleblog.ui.model.ArticleUiModel
import kotlinx.coroutines.launch

class ArticleDetailsViewModel(private val getArticleByIdUseCase: GetArticleByIdUseCase) : ViewModel() {
    
    private val _articleLiveData: MutableLiveData<ArticleUiModel> = MutableLiveData()
    val articleLiveData: LiveData<ArticleUiModel> get() = _articleLiveData
    
    fun getArticleById(id: Int) {
        viewModelScope.launch {
            getArticleByIdUseCase.getArticleById(id.toString())?.let { articleDTO ->
                val articlesUiModel = ArticlesMapperUI.articleDtoToArticleUiModel(articleDTO)
                _articleLiveData.postValue(articlesUiModel)
            }
        }
    }
}