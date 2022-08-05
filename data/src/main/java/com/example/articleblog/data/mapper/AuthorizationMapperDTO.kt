package com.example.articleblog.data.mapper

import com.example.articleblog.data.source.remote.model.LoginRequest
import com.example.articleblog.data.source.remote.model.RegisterRequest
import com.example.articleblog.data.source.remote.model.TokenResponse
import com.example.articleblog.domain.model.LoginDTO
import com.example.articleblog.domain.model.RegisterDTO
import com.example.articleblog.domain.model.TokenDTO

object AuthorizationMapperDTO {
    fun loginDtoToRequest(loginDTO: LoginDTO) =
        LoginRequest(login = loginDTO.login, password = loginDTO.password)
    
    fun registerDtoToRequest(registerDTO: RegisterDTO) =
        RegisterRequest(login = registerDTO.login, password = registerDTO.password)
    
    fun tokenResponseToDTO(tokenResponse: TokenResponse) = TokenDTO(
            token = tokenResponse.token,
            isError = tokenResponse.isError,
            errorMessage = tokenResponse.errorMessage ?: ""
        )
    
}