package com.himawanmasyaid.newsapp.data.model

class NewsCategoryModel(
    val category: String
) {

    fun getAll(): List<NewsCategoryModel> {
        return listOf(
            NewsCategoryModel("business"),
            NewsCategoryModel("entertainment"),
            NewsCategoryModel("health"),
            NewsCategoryModel("sports"),
            NewsCategoryModel("technology"),
            NewsCategoryModel("science"),
        )
    }

}