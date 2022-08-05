package com.example.articleblog.ui.fragment.registration

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.articleblog.domain.usecase.RegisterUserUseCase
import com.example.articleblog.ui.mapper.AuthorizationMapperUI
import com.example.articleblog.ui.model.RegisterUiModel
import com.example.articleblog.utils.Constants
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
            try {
                val registerUiModel =
                    AuthorizationMapperUI.mapRegisterUiModel(
                        login = login,
                        password = password,
                        passwordRepeat = passwordRepeat
                    )
                Log.d("registerUiModel", registerUiModel.toString())
                if (isValid(registerUiModel)) {
                    val registerDTO = AuthorizationMapperUI.mapRegisterUiModelToDTO(registerUiModel)
                    val tokenDTO = registerUserUseCase.registerUser(registerDTO)
                    if (tokenDTO.isError) sendError(tokenDTO.errorMessage)
                    else _tokenLiveData.postValue(tokenDTO.token)
                }
            } catch (e: Exception) {
                e.printStackTrace().toString()
                registerFailedChannel.send("Ошибка соединения с сервером")
            }
        }
    }
    
    private fun sendError(errorMessage: String) {
        viewModelScope.launch {
            when (errorMessage) {
                Constants.NOT_FOUND -> registerFailedChannel.send("Ошибка соединения с сервером")
                Constants.BAD_REQUEST -> registerFailedChannel.send("Неверный логин или пароль")
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