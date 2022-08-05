package com.example.articleblog.di

import com.example.articleblog.domain.repository.ArticlesRepository
import com.example.articleblog.domain.usecase.GetArticlesUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    
    @Provides
    fun provideGetArticlesUseCase(articlesRepository: ArticlesRepository): GetArticlesUseCase {
        return GetArticlesUseCase(articlesRepository = articlesRepository)
    }
}