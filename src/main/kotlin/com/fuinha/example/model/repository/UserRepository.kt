package com.fuinha.example.model.repository

import com.fuinha.example.model.User
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository : CrudRepository<User, UUID>