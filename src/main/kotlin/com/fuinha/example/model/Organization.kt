package com.fuinha.example.model

import jakarta.persistence.*
import org.hibernate.annotations.UuidGenerator
import java.util.*

@Entity
class Organization(
    @Column(nullable = false)
    var displayName: String,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var organizationType: OrganizationType,

    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    val id: UUID? = null
)

enum class OrganizationType {
    ADMIN,
    DEALER,
    WORKSHOP,
}