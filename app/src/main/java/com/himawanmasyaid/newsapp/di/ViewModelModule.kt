package com.himawanmasyaid.newsapp.di

import com.himawanmasyaid.newsapp.vm.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { NewsViewModel(get()) }

}


