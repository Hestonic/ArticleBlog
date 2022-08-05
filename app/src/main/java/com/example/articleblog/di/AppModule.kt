package com.example.articleblog.di

import android.content.Context
import com.example.articleblog.domain.usecase.GetArticlesUseCase
import com.example.articleblog.ui.fragment.articles.ArticlesViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {
    
    @Provides
    fun provideContext() : Context { return context }
    
    @Provides
    fun provideArticlesViewModelFactory(getArticlesUseCase: GetArticlesUseCase): ArticlesViewModelFactory {
        return ArticlesViewModelFactory(getArticlesUseCase = getArticlesUseCase)
    }
}