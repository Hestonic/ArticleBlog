package com.example.articleblog.ui.fragment.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.articleblog.domain.usecase.RegisterUserUseCase
import com.example.articleblog.ui.mapper.AuthorizationMapperUI
import com.example.articleblog.ui.model.RegisterUiModel
import com.example.articleblog.utils.Constants.Companion.BAD_REQUEST
import com.example.articleblog.utils.Constants.Companion.CONFLICT
import com.example.articleblog.utils.Constants.Companion.NOT_FOUND
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class RegistrationViewModel(private val registerUserUseCase: RegisterUserUseCase) : ViewModel() {
    
    private val _tokenLiveData: MutableLiveData<String> = MutableLiveData()
    val tokenLiveData: LiveData<String> get() = _tokenLiveData
    
    private val registerFailedChannel = Channel<String>()
    val registerFailedFlow get() = registerFailedChannel.receiveAsFlow()
    
    fun loginUser(login: String, password: String, passwordRepeat: String) {
        viewModelScope.launch {
    
            val registerUiModel = AuthorizationMapperUI.mapRegisterUiModel(
                login = login,
                password = password,
                passwordRepeat = passwordRepeat
            )
            if (isValid(registerUiModel)) {
                val registerDTO = AuthorizationMapperUI.mapRegisterUiModelToDTO(registerUiModel)
                val token = registerUserUseCase.registerUser(registerDTO)
                try {
                    when (token) {
                        BAD_REQUEST -> registerFailedChannel.send("Can't create user")
                        CONFLICT -> registerFailedChannel.send("User already exists")
                        NOT_FOUND -> registerFailedChannel.send("Server connection error. Check internet connections ")
                        else -> _tokenLiveData.postValue(token)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    registerFailedChannel.send("Server error. Try again later")
                }
            }
        }
    }
    
    private fun isValid(registerUiModel: RegisterUiModel): Boolean {
        return isLoginValid(registerUiModel.login) &&
          isPasswordsLengthValid(registerUiModel.password, registerUiModel.passwordRepeat) &&
          isPasswordsMatch(registerUiModel.password, registerUiModel.passwordRepeat)
          
    }
    
    private fun isLoginValid(login: String): Boolean {
        return if (login.length > 5) true
        else {
            viewModelScope.launch { registerFailedChannel.send("Минимальная длинна логина или пароля 6 символов") }
            false
        }
    }
    
    private fun isPasswordsLengthValid(password: String, passwordRepeat: String): Boolean {
        return if (password.length > 5 && passwordRepeat.length > 5) true
        else {
            viewModelScope.launch { registerFailedChannel.send("Минимальная длинна логина или пароля 6 символов") }
            false
        }
    }
    
    private fun isPasswordsMatch(password: String, passwordRepeat: String): Boolean {
        return if (password == passwordRepeat) true
        else {
            viewModelScope.launch { registerFailedChannel.send("Пароли не совпадают") }
            false
        }
    }
}