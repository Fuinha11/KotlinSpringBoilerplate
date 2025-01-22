package com.fuinha.example.service.impl

import com.fuinha.example.exception.EntityNotFoundException
import com.fuinha.example.model.Organization
import com.fuinha.example.model.repository.OrganizationRepository
import com.fuinha.example.service.OrganizationService
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrganizationServiceImpl(
    private val repository: OrganizationRepository
) : OrganizationService {

    override fun getById(id: UUID): Organization {
        return repository.findById(id).orElseThrow {
            EntityNotFoundException(Organization::class, id)
        }
    }

}