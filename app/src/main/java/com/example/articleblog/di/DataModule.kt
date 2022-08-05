package com.example.articleblog.di

import android.content.Context
import com.example.articleblog.data.repository.ArticlesRepositoryImpl
import com.example.articleblog.data.repository.AuthorizationRepositoryImpl
import com.example.articleblog.data.repository.UserRepositoryImpl
import com.example.articleblog.data.source.RemoteDataSource
import com.example.articleblog.data.source.local.SessionManager
import com.example.articleblog.data.source.remote.ArticleService
import com.example.articleblog.domain.repository.ArticlesRepository
import com.example.articleblog.domain.repository.AuthorizationRepository
import com.example.articleblog.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class])
class DataModule {
    
    @Provides
    fun provideRemoteDataSource(api: ArticleService) : RemoteDataSource {
        return RemoteDataSource(api = api)
    }
    
    @Provides
    fun provideSessionManager(context: Context): SessionManager {
        return SessionManager(context)
    }
    
    @Provides
    fun provideArticlesRepository(remoteDataSource: RemoteDataSource) : ArticlesRepository {
        return ArticlesRepositoryImpl(remoteDataSource = remoteDataSource)
    }
    
    @Provides
    fun provideUserRepository(remoteDataSource: RemoteDataSource) : UserRepository {
        return UserRepositoryImpl(remoteDataSource = remoteDataSource)
    }
    
    @Provides
    fun provideAuthorizationRepository(remoteDataSource: RemoteDataSource) : AuthorizationRepository {
        return AuthorizationRepositoryImpl(remoteDataSource = remoteDataSource)
    }
}