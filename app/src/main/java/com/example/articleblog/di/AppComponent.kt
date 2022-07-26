package com.example.articleblog.di

import com.example.articleblog.ui.fragment.article_details.ArticleDetailsFragment
import com.example.articleblog.ui.fragment.articles.ArticlesFragment
import com.example.articleblog.ui.fragment.login.LoginFragment
import com.example.articleblog.ui.fragment.registration.RegistrationFragment
import com.example.articleblog.ui.fragment.write_article.WriteArticleFragment
import dagger.Component

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {
    fun inject(articlesFragment: ArticlesFragment)
    fun inject(loginFragment: LoginFragment)
    fun inject(registrationFragment: RegistrationFragment)
    fun inject(articleDetailsFragment: ArticleDetailsFragment)
    fun inject(writeArticleFragment: WriteArticleFragment)
}