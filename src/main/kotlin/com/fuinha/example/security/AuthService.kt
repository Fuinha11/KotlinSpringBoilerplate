package com.fuinha.example.security

import com.fuinha.example.web.dto.response.TokenDto

interface AuthService {
    fun generateTokenForUser(username: String, password: String): TokenDto
}