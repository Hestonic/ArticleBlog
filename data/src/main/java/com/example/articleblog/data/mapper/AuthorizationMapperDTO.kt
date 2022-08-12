package com.example.articleblog.data.mapper

import com.example.articleblog.data.source.remote.model.LoginRequest
import com.example.articleblog.data.source.remote.model.RegisterRequest
import com.example.articleblog.domain.model.LoginDTO
import com.example.articleblog.domain.model.RegisterDTO

object AuthorizationMapperDTO {
    fun loginDtoToRequest(loginDTO: LoginDTO) =
        LoginRequest(login = loginDTO.login, password = loginDTO.password)
    
    fun registerDtoToRequest(registerDTO: RegisterDTO) =
        RegisterRequest(login = registerDTO.login, password = registerDTO.password)
}