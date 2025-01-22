package com.fuinha.example.web

import com.fuinha.example.service.OrganizationService
import com.fuinha.example.web.dto.BaseResponse
import com.fuinha.example.web.dto.response.OrganizationDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("organization")
class OrganizationController(
    val organizationService: OrganizationService
) {

    @GetMapping("/{organizationId}")
    fun getOrganizationById(@PathVariable organizationId: UUID): BaseResponse<OrganizationDto> {
        return BaseResponse(OrganizationDto(organizationService.getById(organizationId)))
    }
}