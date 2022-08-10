package com.example.articleblog.ui.fragment.write_article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.articleblog.domain.usecase.GetAllCategoriesUseCase
import com.example.articleblog.ui.mapper.ArticlesMapperUI
import com.example.articleblog.ui.model.CategoryUiModel
import kotlinx.coroutines.launch

// TODO: собщение об ошибке в случае неудачного запроса
class WriteArticleViewModel(private val getAllCategoriesUseCase: GetAllCategoriesUseCase) :
    ViewModel() {
    
    private val _categoriesLiveData: MutableLiveData<List<CategoryUiModel>> = MutableLiveData()
    val categoriesLiveData: LiveData<List<CategoryUiModel>> get() = _categoriesLiveData
    
    fun getAllCategories() {
        viewModelScope.launch {
            val listCategoriesDTO = getAllCategoriesUseCase.getAllCategories()
            val listCategoriesUiModel =
                ArticlesMapperUI.listCategoriesDtoToUiModel(listCategoriesDTO)
            _categoriesLiveData.postValue(listCategoriesUiModel)
        }
    }
}