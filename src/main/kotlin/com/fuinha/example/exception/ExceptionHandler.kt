package com.fuinha.example.exception

import com.fuinha.example.web.dto.BaseResponse
import com.fuinha.example.web.dto.ErrorResponse
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler
    fun handleGenericException(exception: Exception): ResponseEntity<BaseResponse<*>> {
        val e = if (exception is ExampleException) exception else GenericException(exception)
        return ResponseEntity(BaseResponse(null, ErrorResponse(e)), HttpStatusCode.valueOf(400))
    }
}