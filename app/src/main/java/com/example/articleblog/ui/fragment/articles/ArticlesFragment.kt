package com.example.articleblog.ui.fragment.articles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.articleblog.App
import com.example.articleblog.databinding.FragmentArticlesBinding
import javax.inject.Inject

class ArticlesFragment : Fragment() {
    
    @Inject
    lateinit var articlesViewModelFactory: ArticlesViewModelFactory
    
    private lateinit var viewModel: ArticlesViewModel
    private lateinit var binding: FragmentArticlesBinding
    private val adapter = ArticlesAdapter()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App).appComponent.inject(this)
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArticlesBinding.inflate(inflater, container, false)
        setupRecyclerview()
        initViewModel()
        viewModel.getArticles()
        viewModel.articlesLiveData.observe(viewLifecycleOwner) { adapter.setData(it.articlesList) }
        return binding.root
    }
    
    private fun setupRecyclerview() {
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
    }
    
    private fun initViewModel() {
        viewModel =
            ViewModelProvider(this, articlesViewModelFactory)[ArticlesViewModel::class.java]
    }
}