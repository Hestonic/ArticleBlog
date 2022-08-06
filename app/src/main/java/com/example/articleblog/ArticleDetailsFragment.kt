package com.example.articleblog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.articleblog.databinding.FragmentArticleDetailsBinding

class ArticleDetailsFragment : Fragment() {
    
    private lateinit var binding: FragmentArticleDetailsBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArticleDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }
}