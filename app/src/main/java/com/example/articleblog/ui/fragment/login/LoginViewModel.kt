package com.example.articleblog.ui.fragment.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.articleblog.domain.usecase.LoginUserUseCase
import com.example.articleblog.ui.mapper.AuthorizationMapperUI
import com.example.articleblog.utils.Constants.Companion.BAD_REQUEST
import com.example.articleblog.utils.Constants.Companion.NOT_FOUND
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUserUseCase: LoginUserUseCase) : ViewModel() {
    
    private val _tokenLiveData: MutableLiveData<String> = MutableLiveData()
    val tokenLiveData: LiveData<String> get() = _tokenLiveData
    
    private val loginFailedChannel = Channel<String>()
    val loginFailedFlow get() = loginFailedChannel.receiveAsFlow()
    
    fun loginUser(login: String, password: String) {
        viewModelScope.launch {
            val loginUiModel =
                AuthorizationMapperUI.mapLoginUiModel(login = login, password = password)
            val loginDTO = AuthorizationMapperUI.mapLoginUiModelToDTO(loginUiModel)
            val token = loginUserUseCase.loginUser(loginDTO)
            try {
                when (token) {
                    BAD_REQUEST -> loginFailedChannel.send("Wrong login or password")
                    NOT_FOUND -> loginFailedChannel.send("Server connection error. Check internet connections ")
                    else -> _tokenLiveData.postValue(token)
                }
            } catch (e: Exception) {
                loginFailedChannel.send("Server error. Try again later")
            }
        }
    }
}