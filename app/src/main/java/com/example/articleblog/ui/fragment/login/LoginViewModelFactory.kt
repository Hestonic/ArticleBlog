package com.example.articleblog.ui.fragment.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.articleblog.domain.usecase.LoginUserUseCase

class LoginViewModelFactory(private val loginUserUseCase: LoginUserUseCase) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java))
            return LoginViewModel(loginUserUseCase) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}