package com.example.articleblog.ui.fragment.articles

import androidx.recyclerview.widget.RecyclerView
import com.example.articleblog.databinding.ItemArticleBinding
import com.example.articleblog.ui.model.ArticleUiModel

class ArticlesViewHolder (private val binding: ItemArticleBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(article: ArticleUiModel) = binding.run {
        binding.articleName.text = article.tittle
        binding.articleText.text = article.text
        binding.eyeValue.text = article.articleInfo.views
        binding.likeValue.text = article.articleInfo.likes
        binding.categories.text = article.categories.first().category
    }
}