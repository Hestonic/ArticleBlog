package com.example.articleblog.ui.fragment.write_article

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.articleblog.databinding.FragmentWriteArticleBinding

class WriteArticleFragment : Fragment() {
    
    private lateinit var binding: FragmentWriteArticleBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWriteArticleBinding.inflate(inflater, container, false)
        return binding.root
    }
}