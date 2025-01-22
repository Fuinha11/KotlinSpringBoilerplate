package com.fuinha.example.security

import com.fuinha.example.exception.EntityNotFoundException
import com.fuinha.example.model.User
import com.fuinha.example.model.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

private const val ROOT_USER_ID = "cb183e77-8b9a-4cfa-91d3-4e72f2b9ced4"

@Service
class SecurityServiceImpl(
    val userRepository: UserRepository
) : SecurityService {
    override fun getLoggedInUser(): User {
        return userRepository.findById(UUID.fromString(ROOT_USER_ID))
            .orElseThrow { EntityNotFoundException(User::class, UUID.fromString(ROOT_USER_ID)) }
    }
}