package com.fuinha.example.exception

import java.util.*
import kotlin.reflect.KClass

class EntityNotFoundException(type: KClass<*>, id: UUID) :
    ExampleException(ExceptionType.NOT_FOUND, type.simpleName, id.toString())