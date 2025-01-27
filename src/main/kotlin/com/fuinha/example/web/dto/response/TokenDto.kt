package com.fuinha.example.web.dto.response

import java.util.*

class TokenDto(
    val token: String,
    val expiresAt: Date,
    val scope: String = "Bearer"
)