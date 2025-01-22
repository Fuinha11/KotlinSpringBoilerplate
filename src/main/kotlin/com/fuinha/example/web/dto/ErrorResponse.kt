package com.fuinha.example.web.dto

import com.fuinha.example.exception.ExampleException

class ErrorResponse(
    exampleException: ExampleException
) {
    val code = exampleException.code
    val message = exampleException.message
}