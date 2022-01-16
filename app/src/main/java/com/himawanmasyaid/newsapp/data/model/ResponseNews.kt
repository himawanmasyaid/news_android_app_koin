package com.himawanmasyaid.newsapp.data.model


import com.google.gson.annotations.SerializedName

data class ResponseNews(
    @SerializedName("articles")
    val articles: List<NewsModel> = listOf(),
    @SerializedName("status")
    val status: String = "",
    @SerializedName("totalResults")
    val totalResults: Int = 0
)