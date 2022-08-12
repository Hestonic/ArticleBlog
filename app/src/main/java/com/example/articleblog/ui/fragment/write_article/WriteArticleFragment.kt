package com.example.articleblog.ui.fragment.write_article

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.articleblog.App
import com.example.articleblog.R
import com.example.articleblog.databinding.FragmentWriteArticleBinding
import com.example.articleblog.ui.model.CategoryUiModel
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
            setupAdapterToAutoCompleteTextView(listCategoriesUiModel)
        }
        
        binding.autoCompleteCategory.setOnItemClickListener { adapterView, _, position, _ ->
            addCategory(adapterView, position)
        }
    
        viewModel.categoriesStringsLiveData.observe(viewLifecycleOwner) { adapter.setData(it) }
    
        
        lifecycleScope.launchWhenStarted {
            viewModel.failedFlow.collect { errorMessage ->
                Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.successFlow.collect { message ->
                Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
                navigateToArticlesFragment()
            }
        }
        
        binding.publishButton.setOnClickListener {
            showPublishAlertDialog()
            publishArticle()
        }
        
        return binding.root
    }
    
    private fun navigateToArticlesFragment() {
        val action = WriteArticleFragmentDirections.actionWriteArticleFragmentToArticlesFragment()
        findNavController().navigate(action)
    }
    
    private fun showPublishAlertDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Publish article")
            .setMessage("Are you sure you want to publish article?")
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(requireContext(), "Publish canceled", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Yes") { _, _ -> publishArticle()}
            .create().show()
    }
    
    private fun publishArticle() {
        val title = binding.titleInput.text.toString()
        val text = binding.textInput.text.toString()
        viewModel.publishArticle(title, text)
    }
    
    private fun setupAdapterToAutoCompleteTextView(listCategoriesUiModel: List<CategoryUiModel>) {
        val categoriesList =
            listCategoriesUiModel.map { categoryUiModel -> categoryUiModel.category }
        val adapterItems =
            ArrayAdapter(requireContext(), R.layout.item_auto_complete, categoriesList)
        binding.autoCompleteCategory.setAdapter(adapterItems)
    }
    
    private fun addCategory(adapterView: AdapterView<*>, position: Int) {
        val category = adapterView.getItemAtPosition(position).toString()
        viewModel.addCategory(category)
        binding.autoCompleteCategory.setText("")
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