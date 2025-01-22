package com.fuinha.example.service

import com.fuinha.example.model.Organization
import java.util.*

interface OrganizationService {
    fun getById(id: UUID): Organization
}