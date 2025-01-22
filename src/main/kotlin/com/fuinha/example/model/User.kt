package com.fuinha.example.model

import jakarta.persistence.*
import org.hibernate.annotations.UuidGenerator
import java.util.*

@Entity
@Table(name = "user_example")
data class User(
    @ManyToOne
    @JoinColumn(nullable = false)
    var organization: Organization,

    @Column(nullable = false)
    var displayName: String,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var role: UserRole = UserRole.VISITOR,

    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    val id: UUID? = null
)

enum class UserRole {
    ADMIN,
    VISITOR,
    DEALER,
    MECHANIC
}