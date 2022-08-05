package com.example.articleblog.di

import android.content.Context
import com.example.articleblog.domain.usecase.GetArticlesUseCase
import com.example.articleblog.domain.usecase.LoginUserUseCase
import com.example.articleblog.domain.usecase.RegisterUserUseCase
import com.example.articleblog.ui.fragment.articles.ArticlesViewModelFactory
import com.example.articleblog.ui.fragment.login.LoginViewModelFactory
import com.example.articleblog.ui.fragment.registration.RegistrationViewModelFactory
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
    fun provideLoginViewModelFactory(loginUserUseCase: LoginUserUseCase): LoginViewModelFactory {
        return LoginViewModelFactory(loginUserUseCase = loginUserUseCase)
    }
    
    @Provides
    fun provideRegistrationViewModelFactory(registerUserUseCase: RegisterUserUseCase): RegistrationViewModelFactory {
        return RegistrationViewModelFactory(registerUserUseCase = registerUserUseCase)
    }
}