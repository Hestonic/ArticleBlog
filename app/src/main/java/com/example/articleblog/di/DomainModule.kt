package com.example.articleblog.di

import com.example.articleblog.domain.repository.ArticlesRepository
import com.example.articleblog.domain.repository.AuthorizationRepository
import com.example.articleblog.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    
    @Provides
    fun provideGetArticlesUseCase(articlesRepository: ArticlesRepository): GetArticlesUseCase {
        return GetArticlesUseCase(articlesRepository = articlesRepository)
    }
    
    @Provides
    fun provideGetArticleUseCase(articlesRepository: ArticlesRepository): GetArticleByIdUseCase {
        return GetArticleByIdUseCase(articlesRepository = articlesRepository)
    }
    
    @Provides
    fun provideLoginUserUseCase(authorizationRepository: AuthorizationRepository): LoginUserUseCase {
        return LoginUserUseCase(authorizationRepository = authorizationRepository)
    }
    
    @Provides
    fun provideRegisterUserUseCase(authorizationRepository: AuthorizationRepository): RegisterUserUseCase {
        return RegisterUserUseCase(authorizationRepository = authorizationRepository)
    }
}