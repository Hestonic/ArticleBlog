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
    
    private val _articlesLiveData: MutableLiveData<ArticlesUiModel> = MutableLiveData()
    val articlesLiveData: LiveData<ArticlesUiModel> get() = _articlesLiveData
    
    fun getArticles() {
        viewModelScope.launch {
            getArticlesUseCase.getArticles()?.let { articlesDTO ->
                val articlesList = articlesDTO.articlesList.map { articleDTO ->
                    ArticleUiModel(
                        id = articleDTO.id,
                        tittle = articleDTO.tittle,
                        text = articleDTO.text,
                        categories = articleDTO.categories.map { categoryDTO ->
                            CategoryUiModel(id = categoryDTO.id, categoryDTO.category)
                        },
                        articleInfo = ArticleInfoUiModel(
                            id = articleDTO.articleInfo.id,
                            likes = articleDTO.articleInfo.likes.toString(),
                            views = articleDTO.articleInfo.views.toString()
                        ),
                    )
                }
                _articlesLiveData.postValue(ArticlesUiModel(articlesList))
            }
        }
    }
}