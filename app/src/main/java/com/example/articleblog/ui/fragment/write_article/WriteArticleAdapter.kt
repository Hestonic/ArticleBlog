package com.example.articleblog.ui.fragment.write_article

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.articleblog.databinding.ItemChipsBinding

class WriteArticleAdapter(private val passClick: WriteArticlePassClick) : RecyclerView.Adapter<WriteArticleViewHolder>() {
    
    private var categoriesList: List<String> = emptyList()
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WriteArticleViewHolder {
        val binding =
            ItemChipsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WriteArticleViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: WriteArticleViewHolder, position: Int) {
        categoriesList.getOrNull(position)?.let { holder.bind(it, passClick) }
    }
    
    override fun getItemCount(): Int = categoriesList.size
    
    @SuppressLint("NotifyDataSetChanged")
    fun setData(categoriesList: List<String>) {
        this.categoriesList = categoriesList
        notifyDataSetChanged()
    }
}