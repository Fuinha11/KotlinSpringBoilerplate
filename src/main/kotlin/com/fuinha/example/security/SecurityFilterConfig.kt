package com.fuinha.example.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.util.*


@Configuration
@EnableWebSecurity
class SecurityFilterConfig(
    private val jwtAuthenticationFilter: JwtAuthenticationFilter,
    val securityConfig: SecurityConfig
) {

    @Bean
    @Throws(java.lang.Exception::class)
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf { csrf -> csrf.disable() }
        http.authorizeHttpRequests { request ->
            request.requestMatchers(
                "/api/v*/registration/**",
                "/register*",
                "/login",
                "/actuator/**",
                "/v3/api-docs/**",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui/**",
                "/webjars/**",
                "/public/**"
            ).permitAll()
            request.anyRequest().authenticated()
        }

        http.sessionManagement { config ->
            config.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        }
        http.authenticationProvider(securityConfig.authenticationProvider())
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)
        return http.build()
    }
}