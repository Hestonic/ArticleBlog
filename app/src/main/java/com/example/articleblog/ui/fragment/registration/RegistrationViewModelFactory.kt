package com.example.articleblog.ui.fragment.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.articleblog.domain.usecase.RegisterUserUseCase
import com.example.articleblog.ui.fragment.login.LoginViewModel

class RegistrationViewModelFactory(private val registerUserUseCase: RegisterUserUseCase) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegistrationViewModel::class.java))
            return RegistrationViewModel(registerUserUseCase) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}