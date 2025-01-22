package com.fuinha.example.service.impl

import com.fuinha.example.exception.EntityNotFoundException
import com.fuinha.example.model.User
import com.fuinha.example.model.repository.UserRepository
import com.fuinha.example.service.UserService
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(
    private val repository: UserRepository
) : UserService {

    override fun getById(id: UUID): User {
        return repository.findById(id).orElseThrow {
            EntityNotFoundException(User::class, id)
        }
    }

}