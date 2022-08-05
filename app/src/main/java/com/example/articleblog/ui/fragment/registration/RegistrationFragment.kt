package com.example.articleblog.ui.fragment.registration

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
import com.example.articleblog.databinding.FragmentRegistrationBinding
import javax.inject.Inject

class RegistrationFragment : Fragment() {
    
    @Inject
    lateinit var registrationViewModelFactory: RegistrationViewModelFactory
    
    @Inject
    lateinit var sessionManager: SessionManager
    private lateinit var viewModel: RegistrationViewModel
    private lateinit var binding: FragmentRegistrationBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext().applicationContext as App).appComponent.inject(this)
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        initViewModel()
        binding.login.setOnClickListener { navigateToLoginFragment() }
        binding.loginButton.setOnClickListener { registerUser() }
        viewModel.tokenLiveData.observe(viewLifecycleOwner) {
            sessionManager.saveAuthToken(it)
            navigateToArticlesFragment()
        }
    
        lifecycleScope.launchWhenStarted {
            viewModel.registerFailedFlow.collect { errorMessage -> makeToast(errorMessage) }
        }
        return binding.root
    }
    
    private fun registerUser() {
        val login = binding.loginInput.text.toString()
        val password = binding.passwordInput.text.toString()
        val passwordRepeat = binding.passwordRepeatInput.text.toString()
        viewModel.loginUser(login, password, passwordRepeat)
    }
    
    private fun initViewModel() {
        viewModel =
            ViewModelProvider(this, registrationViewModelFactory)[RegistrationViewModel::class.java]
    }
    
    private fun makeToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()
    }
    
    private fun navigateToArticlesFragment() {
        val action = RegistrationFragmentDirections.actionRegistrationFragmentToArticlesFragment()
        findNavController().navigate(action)
    }
    
    private fun navigateToLoginFragment() {
        val action = RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment()
        findNavController().navigate(action)
    }
}