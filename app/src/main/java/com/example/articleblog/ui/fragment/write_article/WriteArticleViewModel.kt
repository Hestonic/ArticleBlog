package com.example.articleblog.ui.fragment.write_article

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.articleblog.domain.usecase.GetAllCategoriesUseCase
import com.example.articleblog.domain.usecase.GetLoginUseCase
import com.example.articleblog.domain.usecase.PublishArticleUseCase
import com.example.articleblog.ui.mapper.ArticlesMapperUI
import com.example.articleblog.ui.model.CategoryUiModel
import com.example.articleblog.utils.Constants.Companion.CREATED
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

// TODO: собщение об ошибке в случае неудачного запроса
// TODO: додумать логику с взятием логина
class WriteArticleViewModel(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val publishArticleUseCase: PublishArticleUseCase,
    private val getLoginUseCase: GetLoginUseCase,
) :
    ViewModel() {
    
    private val _categoriesUiModelLiveData: MutableLiveData<List<CategoryUiModel>> =
        MutableLiveData()
    val categoriesUiModelLiveData: LiveData<List<CategoryUiModel>> get() = _categoriesUiModelLiveData
    
    private val _categoriesStringsLiveData: MutableLiveData<List<String>> = MutableLiveData()
    val categoriesStringsLiveData: LiveData<List<String>> get() = _categoriesStringsLiveData
    
    private lateinit var login: String
    
    private val failedChannel = Channel<String>()
    val failedFlow get() = failedChannel.receiveAsFlow()
    
    private val successChannel = Channel<String>()
    val successFlow get() = successChannel.receiveAsFlow()
    
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
    
    fun publishArticle(title: String, text: String) {
        viewModelScope.launch {
            val categories = _categoriesStringsLiveData.value
            if (titleIsValid(title) && textIsValid(text) && categoriesIsValid(categories)) {
                val categoriesUiModel = _categoriesUiModelLiveData.value
                val idsOfSelectedCategories =
                    findIdsOfSelectedCategories(categoriesUiModel, categories)
                val writeArticleUiModel =
                    ArticlesMapperUI.mapWriteArticleUiModel(
                        title,
                        text,
                        idsOfSelectedCategories,
                        login
                    )
                val writeArticleDTO = ArticlesMapperUI.writeArticleUiModelToDTO(writeArticleUiModel)
                val message = publishArticleUseCase.publishArticle(writeArticleDTO)
                Log.d("tag", message)
                when (message) {
                    CREATED -> successChannel.send("Article has been published")
                    else -> failedChannel.send("The article has not been published. Perhaps a problem with the server. Try again later")
                }
            }
        }
    }
    
    fun getLogin(token: String) {
        viewModelScope.launch {
            login = getLoginUseCase.getLogin(token)
        }
    }
    
    private fun findIdsOfSelectedCategories(
        categoriesUiModel: List<CategoryUiModel>?, categories: List<String>?
    ): List<Int> {
        val idsOfSelectedCategories = mutableListOf<Int>()
        categoriesUiModel?.forEach { categoryUiModel ->
            categories?.let {
                if (it.contains(categoryUiModel.category))
                    idsOfSelectedCategories.add(categoryUiModel.id)
            }
        }
        return idsOfSelectedCategories
    }
    
    private fun categoriesIsValid(categories: List<String>?): Boolean {
        return if (categories != null && categories.isNotEmpty()) true
        else {
            viewModelScope.launch { failedChannel.send("Select at least 1 category") }
            false
        }
    }
    
    private fun textIsValid(text: String): Boolean {
        return if (text.length > 100) true
        else {
            viewModelScope.launch { failedChannel.send("The text of the article must contain at least 100 characters") }
            false
        }
    }
    
    private fun titleIsValid(title: String): Boolean {
        return if (title.isNotEmpty()) true
        else if (title.length < 8) {
            viewModelScope.launch { failedChannel.send("The tittle of the article must contain at least 8 characters") }
            false
        }
        else {
            viewModelScope.launch { failedChannel.send("Give title to article") }
            false
        }
    }
}