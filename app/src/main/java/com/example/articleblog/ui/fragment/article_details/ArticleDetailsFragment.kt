package com.example.articleblog.ui.fragment.article_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.articleblog.App
import com.example.articleblog.databinding.FragmentArticleDetailsBinding
import com.example.articleblog.ui.model.ArticleUiModel
import javax.inject.Inject

class ArticleDetailsFragment : Fragment() {
    
    private lateinit var binding: FragmentArticleDetailsBinding
    private val adapter = CategoryAdapter()
    private val args by navArgs<ArticleDetailsFragmentArgs>()
    private lateinit var viewModel: ArticleDetailsViewModel
    
    @Inject
    lateinit var viewModelFactory: ArticleDetailsViewModelFactory
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App).appComponent.inject(this)
        initViewModel()
        viewModel.getArticleById(args.id)
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArticleDetailsBinding.inflate(inflater, container, false)
        setupRecycler()
        viewModel.articleLiveData.observe(viewLifecycleOwner) { articleUiModel ->
            setUi(articleUiModel)
            adapter.setData(articleUiModel.categories)
        }
        return binding.root
    }
    
    private fun setupRecycler() {
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }
    
    private fun setUi(articleUiModel: ArticleUiModel) {
        binding.title.text = articleUiModel.tittle
        binding.text.text = articleUiModel.text
        binding.likeValue.text = articleUiModel.articleInfo.likes
        binding.eyeValue.text = articleUiModel.articleInfo.views
    }
    
    private fun initViewModel() {
        viewModel =
            ViewModelProvider(this, viewModelFactory)[ArticleDetailsViewModel::class.java]
    }
}