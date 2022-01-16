package com.himawanmasyaid.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.himawanmasyaid.newsapp.R
import com.himawanmasyaid.newsapp.base.BaseActivity
import com.himawanmasyaid.newsapp.data.request.HeadlineNewsRequest
import com.himawanmasyaid.newsapp.data.state.ViewState
import com.himawanmasyaid.newsapp.databinding.ActivityMainBinding
import com.himawanmasyaid.newsapp.ui.adapter.NewsAdapter
import com.himawanmasyaid.newsapp.vm.NewsViewModel
import org.koin.android.BuildConfig
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val viewModel by viewModel<NewsViewModel>()

    private val adapterNews by lazy(LazyThreadSafetyMode.NONE) {
        NewsAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getHeadline(HeadlineNewsRequest(
            country = "id"
        ))

        binding.inList.recycler.let {
            it.adapter = adapterNews
            it.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            }
        }

        observe(viewModel.headlineState) {
            when(it) {
                is ViewState.Success -> {
                    adapterNews.news  = it.data
                }
                is ViewState.Error -> {
                    Log.e("error", it.viewError ?: "")
                }
            }
        }


    }

}