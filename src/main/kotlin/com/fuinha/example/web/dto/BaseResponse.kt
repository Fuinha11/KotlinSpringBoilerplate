package com.fuinha.example.web.dto

class BaseResponse<T>(
    val content: T,
    val error: ErrorResponse? = null
)