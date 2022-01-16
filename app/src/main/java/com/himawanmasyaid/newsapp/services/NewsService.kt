package com.himawanmasyaid.newsapp.services

import com.himawanmasyaid.newsapp.data.model.ResponseNews
import org.koin.android.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines")
    suspend fun getHeadlineNews(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): ResponseNews

    @GET("everything")
    suspend fun getSearchNews(
        @Query("q") keyword: String,
        @Query("apiKey") apiKey: String
    ): ResponseNews

    @GET("top-headlines")
    suspend fun getCategoryNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String

        ): ResponseNews

}