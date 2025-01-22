package com.fuinha.example.service

import com.fuinha.example.model.User
import java.util.*

interface UserService {
    fun getById(id: UUID): User
}