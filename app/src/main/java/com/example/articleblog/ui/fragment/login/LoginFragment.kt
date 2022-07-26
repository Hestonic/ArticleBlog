package com.example.articleblog.ui.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.articleblog.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    
    private lateinit var binding: FragmentLoginBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.registration.setOnClickListener { navigateToRegistrationFragment() }
        binding.loginButton.setOnClickListener { navigateToArticlesFragment() }
        return binding.root
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