package com.example.articleblog.di

import com.example.articleblog.domain.repository.ArticlesRepository
import com.example.articleblog.domain.repository.AuthorizationRepository
import com.example.articleblog.domain.usecase.GetArticlesUseCase
import com.example.articleblog.domain.usecase.LoginUserUseCase
import com.example.articleblog.domain.usecase.RegisterUserUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    
    @Provides
    fun provideGetArticlesUseCase(articlesRepository: ArticlesRepository): GetArticlesUseCase {
        return GetArticlesUseCase(articlesRepository = articlesRepository)
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