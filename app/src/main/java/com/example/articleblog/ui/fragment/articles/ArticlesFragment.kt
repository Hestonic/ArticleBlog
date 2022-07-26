package com.example.articleblog.ui.fragment.articles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.articleblog.databinding.FragmentArticlesBinding

class ArticlesFragment : Fragment() {
    
    private lateinit var binding: FragmentArticlesBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArticlesBinding.inflate(inflater, container, false)
        return binding.root
    }
}