package com.example.articleblog.ui.mapper

import com.example.articleblog.domain.model.LoginDTO
import com.example.articleblog.ui.model.LoginUiModel
import com.example.articleblog.ui.model.RegisterUiModel

object AuthorizationMapperUI {
    fun mapLoginUiModel(login: String, password: String) =
        LoginUiModel(login = login, password = password)
    
    fun mapLoginUiModelToDTO(loginUiModel: LoginUiModel) =
        LoginDTO(login = loginUiModel.login, password = loginUiModel.password)
    
    fun mapRegisterUiModel(login: String, password: String) =
        RegisterUiModel(login = login, password = password)
    
    fun mapRegisterUiModelToDTO(registerUiModel: RegisterUiModel) =
        RegisterUiModel(login = registerUiModel.login, password = registerUiModel.password)
}