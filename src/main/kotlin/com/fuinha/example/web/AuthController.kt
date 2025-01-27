package com.fuinha.example.web

import com.fuinha.example.security.AuthService
import com.fuinha.example.web.dto.BaseResponse
import com.fuinha.example.web.dto.request.UserLoginRequest
import com.fuinha.example.web.dto.response.TokenDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/authorization")
class AuthController(
    private val authService: AuthService
) {
    @PostMapping("/login")
    fun login(@RequestBody loginRequest: UserLoginRequest): BaseResponse<TokenDto> {
        val token = authService.generateTokenForUser(loginRequest.username, loginRequest.password)
        return BaseResponse(token)
    }
}