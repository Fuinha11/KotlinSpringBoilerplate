package com.fuinha.example.security.impl

import com.fuinha.example.security.AuthService
import com.fuinha.example.security.JwtService
import com.fuinha.example.model.repository.UserRepository
import com.fuinha.example.web.dto.response.TokenDto
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl(
    val jwService: JwtService,
    val userRepository: UserRepository,
    val authenticationManager: AuthenticationManager
) : AuthService {
    override fun generateTokenForUser(username: String, password: String): TokenDto {
        authenticationManager.authenticate( // don't know how but this checks for the user and verify the encrypted password
            UsernamePasswordAuthenticationToken(
                username,
                password
            )
        )
        return jwService.generateToken(userRepository.findByEmail(username).get())
    }
}