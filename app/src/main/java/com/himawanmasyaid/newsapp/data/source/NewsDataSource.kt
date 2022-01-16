package com.himawanmasyaid.newsapp.data.source

import com.himawanmasyaid.newsapp.data.model.NewsModel
import com.himawanmasyaid.newsapp.data.model.ResponseNews
import com.himawanmasyaid.newsapp.data.request.CategoryNewsRequest
import com.himawanmasyaid.newsapp.data.request.HeadlineNewsRequest
import com.himawanmasyaid.newsapp.data.request.SearchNewsRequest
import java.util.*

interface NewsDataSource {

    suspend fun getHeadlineNews(request: HeadlineNewsRequest): List<NewsModel>

    suspend fun getSearchNews(request: SearchNewsRequest): List<NewsModel>

    suspend fun getCategoryNews(request: CategoryNewsRequest): List<NewsModel>

}