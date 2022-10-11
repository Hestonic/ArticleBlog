package com.example.articleblog

import android.app.Application
import com.example.articleblog.di.AppComponent
import com.example.articleblog.di.AppModule
import com.example.articleblog.di.DaggerAppComponent

class App : Application() {
    
    lateinit var appComponent: AppComponent
    
    override fun onCreate() {
        super.onCreate()
        
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
    
}