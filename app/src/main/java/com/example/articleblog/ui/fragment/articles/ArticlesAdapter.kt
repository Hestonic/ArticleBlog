package com.example.articleblog.ui.fragment.articles

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.articleblog.databinding.ItemArticleBinding
import com.example.articleblog.ui.model.ArticleUiModel

class ArticlesAdapter : RecyclerView.Adapter<ArticlesViewHolder>() {
    
    private var articlesList: List<ArticleUiModel> = emptyList()
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val binding =
            ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticlesViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        articlesList.getOrNull(position)?.let { holder.bind(it) }
    }
    
    override fun getItemCount(): Int = articlesList.size
    
    @SuppressLint("NotifyDataSetChanged")
    fun setData(articlesList: List<ArticleUiModel>) {
        this.articlesList = articlesList
        notifyDataSetChanged()
    }
}