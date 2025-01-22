package com.fuinha.example.model.repository

import com.fuinha.example.model.Organization
import org.springframework.data.repository.CrudRepository
import java.util.*

interface OrganizationRepository : CrudRepository<Organization, UUID>