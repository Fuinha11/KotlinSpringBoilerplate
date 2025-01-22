package com.fuinha.example.exception

open class ExampleException(
    e: ExceptionType,
    vararg args: Any?
) : Exception("Code: ".plus(e.code).plus(". Message: ").plus(e.template.format(*args))) {
    val code = e.code
    override val message = e.template.format(*args)

    override fun toString(): String {
        return "Code: ".plus(code).plus(". Message: ").plus(message)
    }
}