package com.himawanmasyaid.newsapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.himawanmasyaid.newsapp.common.extensions.loadUrlRounded
import com.himawanmasyaid.newsapp.data.model.NewsModel
import com.himawanmasyaid.newsapp.databinding.ItemNewsBinding

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    var news: List<NewsModel> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = news[position]

        holder.bindTo(item)

    }

    override fun getItemCount(): Int = news.size

    inner class ViewHolder(val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bindTo(item: NewsModel) {

                binding.ivNews.loadUrlRounded(item.urlToImage, 14)
                binding.tvTitle.text = item.title
                binding.tvAuthor.text = item.author

            }

    }

}