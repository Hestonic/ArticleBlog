package com.example.articleblog.di

import com.example.articleblog.ui.fragment.articles.ArticlesFragment
import dagger.Component

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {
    fun inject(articlesFragment: ArticlesFragment)
}