package com.example.articleblog.ui.fragment.articles

import androidx.recyclerview.widget.RecyclerView
import com.example.articleblog.databinding.ItemArticleBinding
import com.example.articleblog.ui.model.ArticleUiModel

class ArticlesViewHolder (private val binding: ItemArticleBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(article: ArticleUiModel) = binding.run {
        binding.articleName.text = article.articleName
        binding.articleText.text = article.articleText
        binding.eyeValue.text = article.eyeValue
        binding.likeValue.text = article.likeValue
    }
}