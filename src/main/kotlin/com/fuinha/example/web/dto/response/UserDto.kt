package com.fuinha.example.web.dto.response

import com.fuinha.example.model.User

class UserDto(
    u: User
) {
    val name = u.displayName
    val id = u.id
    val organization = OrganizationDto(u.organization)
}