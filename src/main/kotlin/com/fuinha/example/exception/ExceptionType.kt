package com.fuinha.example.exception

enum class ExceptionType(val code: String, val template: String) {
    GENERIC("INT-0001", "Generic error, cause: %s"),
    NOT_FOUND("INT-0002", "%s with id %s was not found")
}