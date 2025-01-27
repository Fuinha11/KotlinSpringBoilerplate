package com.fuinha.example.model

import jakarta.persistence.*
import org.hibernate.annotations.UuidGenerator
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

@Entity
@Table(name = "user_example")
class User(
    @ManyToOne
    @JoinColumn(nullable = false)
    var organization: Organization,

    @Column(nullable = false, unique = true)
    var email: String,

    @Column(nullable = false)
    var pass: String,

    @Column(nullable = false)
    var displayName: String,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var role: UserRole = UserRole.GUEST,

    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    val id: UUID? = null
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {

        return mutableSetOf(SimpleGrantedAuthority("ROLE_".plus(role.name)))
    }

    override fun getPassword(): String {
        return pass
    }

    override fun getUsername(): String {
        return email
    }
}

enum class UserRole {
    ADMIN,
    SUPER_USER,
    USER,
    GUEST,
}