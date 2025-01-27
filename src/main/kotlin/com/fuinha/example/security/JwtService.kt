package com.fuinha.example.security

import com.fuinha.example.web.dto.response.TokenDto
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service

@Service
interface JwtService {
    fun extractUsername(token: String): String
    fun isTokenValidForUser(token: String, userDetails: UserDetails): Boolean
    fun generateToken(userDetails: UserDetails): TokenDto
}