package com.example.articleblog.ui.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.articleblog.App
import com.example.articleblog.data.source.local.SessionManager
import com.example.articleblog.databinding.FragmentLoginBinding
import javax.inject.Inject

class LoginFragment : Fragment() {
    
    @Inject
    lateinit var loginViewModelFactory: LoginViewModelFactory
    @Inject
    lateinit var sessionManager: SessionManager
    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App).appComponent.inject(this)
        checkSession()
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        initViewModel()
        binding.registration.setOnClickListener { navigateToRegistrationFragment() }
        binding.loginButton.setOnClickListener { loginUser() }
        viewModel.tokenLiveData.observe(viewLifecycleOwner) {
            sessionManager.saveAuthToken(it)
            navigateToArticlesFragment()
        }
        
        lifecycleScope.launchWhenStarted {
            viewModel.loginFailedFlow.collect { errorMessage -> makeToast(errorMessage) }
        }
        return binding.root
    }
    
    private fun loginUser() {
        val login = binding.loginInput.text.toString().trim()
        val password = binding.passwordInput.text.toString().trim()
        viewModel.loginUser(login = login, password = password)
    }
    
    private fun checkSession() {
        val token = sessionManager.getAuthToken()
        if (token != null && token.isNotEmpty()) navigateToArticlesFragment()
    }
    
    private fun initViewModel() {
        viewModel =
            ViewModelProvider(this, loginViewModelFactory)[LoginViewModel::class.java]
    }
    
    private fun makeToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()
    }
    
    private fun navigateToArticlesFragment() {
        val action = LoginFragmentDirections.actionLoginFragmentToArticlesFragment()
        findNavController().navigate(action)
    }
    
    private fun navigateToRegistrationFragment() {
        val action = LoginFragmentDirections.actionLoginFragmentToRegistrationFragment()
        findNavController().navigate(action)
    }
}