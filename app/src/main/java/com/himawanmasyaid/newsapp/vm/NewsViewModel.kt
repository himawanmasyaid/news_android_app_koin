package com.himawanmasyaid.newsapp.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.himawanmasyaid.newsapp.data.model.NewsModel
import com.himawanmasyaid.newsapp.data.model.ResponseNews
import com.himawanmasyaid.newsapp.data.request.CategoryNewsRequest
import com.himawanmasyaid.newsapp.data.request.HeadlineNewsRequest
import com.himawanmasyaid.newsapp.data.request.SearchNewsRequest
import com.himawanmasyaid.newsapp.data.source.NewsDataSource
import com.himawanmasyaid.newsapp.data.state.ViewState
import com.himawanmasyaid.newsapp.repo.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel(
    private val newsRepo: NewsDataSource,
) : ViewModel() {

    // response
    val headlineState = MutableLiveData<ViewState<List<NewsModel>>>()
    val categoryState = MutableLiveData<ViewState<List<NewsModel>>>()
    val searchState = MutableLiveData<ViewState<List<NewsModel>>>()

    fun getHeadline(request: HeadlineNewsRequest) {

        viewModelScope.launch {
            headlineState.postValue(ViewState.Loading())
            try {

                val response = newsRepo.getHeadlineNews(request)
                headlineState.postValue(ViewState.Success(response))

            } catch (error: Exception) {
                headlineState.postValue(ViewState.Error(error.message))
            }
        }

    }

    fun getCategory(request: CategoryNewsRequest) {

        viewModelScope.launch {
            categoryState.postValue(ViewState.Loading())
            try {
                val response = newsRepo.getCategoryNews(request)
                categoryState.postValue(ViewState.Success(response))
            } catch (error: Exception) {
                categoryState.postValue(ViewState.Error(error.message))
            }
        }
    }

    fun getSearch(request: SearchNewsRequest) {

        viewModelScope.launch {
            searchState.postValue(ViewState.Loading())
            try {
                val response = newsRepo.getSearchNews(request)
                searchState.postValue(ViewState.Success(response))

            } catch (error: Exception) {
                searchState.postValue(ViewState.Error(error.message))
            }
        }

    }

}