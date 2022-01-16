package com.himawanmasyaid.newsapp.di

import com.himawanmasyaid.newsapp.data.source.NewsDataSource
import com.himawanmasyaid.newsapp.repo.NewsRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<NewsDataSource> { NewsRepository(get()) }

}