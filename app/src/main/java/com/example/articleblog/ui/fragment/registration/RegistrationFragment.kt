package com.example.articleblog.ui.fragment.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.articleblog.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {
    
    private lateinit var binding: FragmentRegistrationBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        binding.login.setOnClickListener { navigateToLoginFragment() }
        return binding.root
    }
    
    private fun navigateToLoginFragment() {
        val action = RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment()
        findNavController().navigate(action)
    }
}