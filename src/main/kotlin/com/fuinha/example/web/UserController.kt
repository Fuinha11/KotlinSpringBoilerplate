package com.fuinha.example.web

import com.fuinha.example.service.UserService
import com.fuinha.example.web.dto.BaseResponse
import com.fuinha.example.web.dto.response.UserDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("user")
class UserController(
    val userService: UserService
) {

    @GetMapping("/{userId}")
    fun getUserById(@PathVariable userId: UUID): BaseResponse<UserDto> {
        return BaseResponse(UserDto(userService.getById(userId)))
    }
}