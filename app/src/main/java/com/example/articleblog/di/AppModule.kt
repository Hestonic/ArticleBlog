package com.example.articleblog.di

import android.content.Context
import com.example.articleblog.domain.usecase.*
import com.example.articleblog.ui.fragment.article_details.ArticleDetailsViewModelFactory
import com.example.articleblog.ui.fragment.articles.ArticlesViewModelFactory
import com.example.articleblog.ui.fragment.login.LoginViewModelFactory
import com.example.articleblog.ui.fragment.registration.RegistrationViewModelFactory
import com.example.articleblog.ui.fragment.write_article.WriteArticleViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {
    
    @Provides
    fun provideContext(): Context {
        return context
    }
    
    @Provides
    fun provideArticlesViewModelFactory(getArticlesUseCase: GetArticlesUseCase): ArticlesViewModelFactory {
        return ArticlesViewModelFactory(getArticlesUseCase = getArticlesUseCase)
    }
    
    @Provides
    fun provideArticleDetailsViewModelFactory(getArticleByIdUseCase: GetArticleByIdUseCase): ArticleDetailsViewModelFactory {
        return ArticleDetailsViewModelFactory(getArticleByIdUseCase = getArticleByIdUseCase)
    }
    
    @Provides
    fun provideLoginViewModelFactory(loginUserUseCase: LoginUserUseCase): LoginViewModelFactory {
        return LoginViewModelFactory(loginUserUseCase = loginUserUseCase)
    }
    
    @Provides
    fun provideRegistrationViewModelFactory(registerUserUseCase: RegisterUserUseCase): RegistrationViewModelFactory {
        return RegistrationViewModelFactory(registerUserUseCase = registerUserUseCase)
    }
    
    @Provides
    fun provideWriteArticleViewModelFactory(
        getAllCategoriesUseCase: GetAllCategoriesUseCase,
        publishArticleUseCase: PublishArticleUseCase,
        getLoginUseCase: GetLoginUseCase,
    ): WriteArticleViewModelFactory {
        return WriteArticleViewModelFactory(
            getAllCategoriesUseCase = getAllCategoriesUseCase,
            publishArticleUseCase = publishArticleUseCase,
            getLoginUseCase = getLoginUseCase,
        )
    }
}