package com.example.articleblog.data.source

import android.util.Log
import com.example.articleblog.data.source.remote.ArticleService
import com.example.articleblog.data.source.remote.model.ArticlesResponse

class RemoteDataSource(private val api: ArticleService) {
    
    suspend fun getArticles(): ArticlesResponse? {
        val articlesResponse = api.getArticles()
        return if (articlesResponse.isSuccessful) {
            Log.d("response", articlesResponse.body().toString())
            articlesResponse.body()
        } else {
            Log.d("response", articlesResponse.toString())
            null
        }
    }
}