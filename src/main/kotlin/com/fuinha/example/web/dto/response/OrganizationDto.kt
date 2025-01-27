package com.fuinha.example.web.dto.response

import com.fuinha.example.model.Organization

class OrganizationDto(
    o: Organization
) {
    val name = o.displayName
    val id = o.id
}