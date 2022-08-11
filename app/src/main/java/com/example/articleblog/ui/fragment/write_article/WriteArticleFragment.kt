package com.example.articleblog.ui.fragment.write_article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.articleblog.App
import com.example.articleblog.R
import com.example.articleblog.databinding.FragmentWriteArticleBinding
import javax.inject.Inject

class WriteArticleFragment : Fragment(), WriteArticlePassClick {
    
    @Inject
    lateinit var writeArticleViewModelFactory: WriteArticleViewModelFactory
    lateinit var viewModel: WriteArticleViewModel
    private val adapter = WriteArticleAdapter(this)
    private lateinit var binding: FragmentWriteArticleBinding
    
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
    
        viewModel.categoriesUiModelLiveData.observe(viewLifecycleOwner) { listCategoriesUiModel ->
            val categoriesList =
                listCategoriesUiModel.map { categoryUiModel -> categoryUiModel.category }
            val adapterItems =
                ArrayAdapter(requireContext(), R.layout.item_auto_complete, categoriesList)
            binding.autoCompleteCategory.setAdapter(adapterItems)
        }
    
        binding.autoCompleteCategory.setOnItemClickListener { adapterView, _, position, _ ->
            val category = adapterView.getItemAtPosition(position).toString()
            viewModel.addCategory(category)
            binding.autoCompleteCategory.setText("")
        }
    
        viewModel.categoriesStringsLiveData.observe(viewLifecycleOwner) { adapter.setData(it) }
    
        return binding.root
    }
    
    override fun deleteCategory(category: String) {
        viewModel.deleteCategory(category)
    }
    
    private fun initViewModel() {
        viewModel =
            ViewModelProvider(this, writeArticleViewModelFactory)[WriteArticleViewModel::class.java]
    }
    
    private fun setupRecycler() {
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }
}