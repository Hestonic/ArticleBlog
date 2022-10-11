package com.example.articleblog.ui.fragment.article_details

import androidx.recyclerview.widget.RecyclerView
import com.example.articleblog.databinding.ItemChipsBinding
import com.example.articleblog.ui.model.CategoryUiModel

class ArticleDetailsViewHolder(private val binding: ItemChipsBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(categoryUiModel: CategoryUiModel) = binding.run {
        binding.categories.text = categoryUiModel.category
    }
}