package com.fuinha.example.exception

class GenericException(e: Exception) : ExampleException(ExceptionType.GENERIC, e.message)