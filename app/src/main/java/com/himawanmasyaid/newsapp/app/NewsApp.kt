package com.himawanmasyaid.newsapp.app

import android.app.Application
import com.himawanmasyaid.newsapp.di.appModule
import com.himawanmasyaid.newsapp.di.networkModule
import com.himawanmasyaid.newsapp.di.repositoryModule
import com.himawanmasyaid.newsapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NewsApp: Application()  {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@NewsApp)
            modules(
                arrayListOf(
                    appModule, viewModelModule, repositoryModule, networkModule
                )
            )
        }
    }
}