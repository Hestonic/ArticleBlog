package com.example.articleblog.ui.fragment.write_article

import androidx.recyclerview.widget.RecyclerView
import com.example.articleblog.databinding.ItemChipsBinding

class WriteArticleViewHolder(private val binding: ItemChipsBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(category: String, passClick: WriteArticlePassClick) = binding.run {
        binding.categories.text = category
        itemView.setOnClickListener { passClick.deleteCategory(category) }
    }
}