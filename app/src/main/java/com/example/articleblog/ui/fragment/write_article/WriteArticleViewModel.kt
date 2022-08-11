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
    
    private val _categoriesUiModelLiveData: MutableLiveData<List<CategoryUiModel>> =
        MutableLiveData()
    val categoriesUiModelLiveData: LiveData<List<CategoryUiModel>> get() = _categoriesUiModelLiveData
    
    private val _categoriesStringsLiveData: MutableLiveData<List<String>> = MutableLiveData()
    val categoriesStringsLiveData: LiveData<List<String>> get() = _categoriesStringsLiveData
    
    fun getAllCategories() {
        viewModelScope.launch {
            val listCategoriesDTO = getAllCategoriesUseCase.getAllCategories()
            val listCategoriesUiModel =
                ArticlesMapperUI.listCategoriesDtoToUiModel(listCategoriesDTO)
            _categoriesUiModelLiveData.postValue(listCategoriesUiModel)
        }
    }
    
    fun addCategory(category: String) {
        val categoriesList = _categoriesStringsLiveData.value
        if (categoriesList == null) _categoriesStringsLiveData.postValue(listOf(category))
        else {
            val categoriesMutableList = categoriesList.toMutableList()
            categoriesMutableList.add(category)
            _categoriesStringsLiveData.postValue(categoriesMutableList.distinct())
        }
    }
    
    fun deleteCategory(category: String) {
        _categoriesStringsLiveData.value?.let { categoriesList ->
            val categoriesMutableList = categoriesList.toMutableList()
            categoriesMutableList.remove(category)
            _categoriesStringsLiveData.postValue(categoriesMutableList)
        }
    }
}