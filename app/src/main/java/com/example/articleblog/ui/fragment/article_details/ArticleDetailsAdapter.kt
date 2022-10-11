package com.example.articleblog.ui.fragment.article_details

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.articleblog.databinding.ItemChipsBinding
import com.example.articleblog.ui.model.CategoryUiModel

class ArticleDetailsAdapter : RecyclerView.Adapter<ArticleDetailsViewHolder>() {
    
    private var categoriesList: List<CategoryUiModel> = emptyList()
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleDetailsViewHolder {
        val binding =
            ItemChipsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleDetailsViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: ArticleDetailsViewHolder, position: Int) {
        categoriesList.getOrNull(position)?.let { holder.bind(it) }
    }
    
    override fun getItemCount(): Int = categoriesList.size
    
    @SuppressLint("NotifyDataSetChanged")
    fun setData(categoriesList: List<CategoryUiModel>) {
        this.categoriesList = categoriesList
        notifyDataSetChanged()
    }
}