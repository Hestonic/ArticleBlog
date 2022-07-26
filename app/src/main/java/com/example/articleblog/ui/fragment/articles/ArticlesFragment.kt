package com.example.articleblog.ui.fragment.articles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.articleblog.databinding.FragmentArticlesBinding
import com.example.articleblog.ui.model.Articles

class ArticlesFragment : Fragment() {
    
    private lateinit var binding: FragmentArticlesBinding
    private val adapter = ArticlesAdapter()
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArticlesBinding.inflate(inflater, container, false)
        setupRecyclerview()
        adapter.setData(Articles.articleList)
        return binding.root
    }
    
    private fun setupRecyclerview() {
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
    }
}