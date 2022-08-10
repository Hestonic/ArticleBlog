package com.example.articleblog.ui.fragment.write_article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.articleblog.App
import com.example.articleblog.R
import com.example.articleblog.databinding.FragmentWriteArticleBinding
import com.example.articleblog.ui.fragment.article_details.ArticleDetailsAdapter
import com.example.articleblog.ui.model.CategoryUiModel
import javax.inject.Inject

class WriteArticleFragment : Fragment() {
    
    private lateinit var binding: FragmentWriteArticleBinding
    private val categoryAdapter = ArticleDetailsAdapter()
    private val categoriesList: MutableList<CategoryUiModel> = mutableListOf()
    lateinit var viewModel: WriteArticleViewModel
    
    @Inject
    lateinit var writeArticleViewModelFactory: WriteArticleViewModelFactory
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App).appComponent.inject(this)
        initViewModel()
        viewModel.getAllCategories()
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWriteArticleBinding.inflate(inflater, container, false)
        setupRecycler()
        
        viewModel.categoriesLiveData.observe(viewLifecycleOwner) {
            val adapterItems = ArrayAdapter(requireContext(), R.layout.item_auto_complete, it)
            binding.autoCompleteCategory.setAdapter(adapterItems)
        }
        
        binding.autoCompleteCategory.setOnItemClickListener { adapterView, _, position, _ ->
            val item = adapterView.getItemAtPosition(position).toString()
            Toast.makeText(requireContext(), "$position: $item", Toast.LENGTH_SHORT).show()
            categoriesList.add(CategoryUiModel(id = position, category = item))
            categoryAdapter.setData(categoriesList)
            binding.autoCompleteCategory.setText("")
        }
        
        return binding.root
    }
    
    private fun initViewModel() {
        viewModel =
            ViewModelProvider(this, writeArticleViewModelFactory)[WriteArticleViewModel::class.java]
    }
    
    private fun setupRecycler() {
        binding.recycler.adapter = categoryAdapter
        binding.recycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }
}