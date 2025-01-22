package com.fuinha.example.security

import com.fuinha.example.model.User

interface SecurityService {
    fun getLoggedInUser(): User
}