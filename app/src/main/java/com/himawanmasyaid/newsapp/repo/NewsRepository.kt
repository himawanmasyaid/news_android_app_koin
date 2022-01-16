package com.himawanmasyaid.newsapp.repo

import com.himawanmasyaid.newsapp.data.model.NewsModel
import com.himawanmasyaid.newsapp.data.model.ResponseNews
import com.himawanmasyaid.newsapp.data.request.CategoryNewsRequest
import com.himawanmasyaid.newsapp.data.request.HeadlineNewsRequest
import com.himawanmasyaid.newsapp.data.request.SearchNewsRequest
import com.himawanmasyaid.newsapp.data.source.NewsDataSource
import com.himawanmasyaid.newsapp.services.NewsService

class NewsRepository(
    private val services: NewsService
    ): NewsDataSource {

    private val API_KEY = "e8c6268442f94048b6483b13d122aed6"

    override suspend fun getHeadlineNews(request: HeadlineNewsRequest): List<NewsModel> {

        val response = services.getHeadlineNews(
            country = request.country,
            apiKey = API_KEY
        )

        return response.articles
    }

    override suspend fun getSearchNews(request: SearchNewsRequest): List<NewsModel> {

        val response = services.getSearchNews(
            keyword = request.keyword,
            apiKey = API_KEY
        )

        return response.articles

    }

    override suspend fun getCategoryNews(request: CategoryNewsRequest): List<NewsModel> {

        val response = services.getCategoryNews(
            country = request.country,
            category = request.category,
            apiKey = API_KEY
        )

        return response.articles
    }
}