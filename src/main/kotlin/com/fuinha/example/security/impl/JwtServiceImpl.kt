package com.fuinha.example.security.impl

import com.fuinha.example.security.JwtService
import com.fuinha.example.web.dto.response.TokenDto
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.util.*

@Service
class JwtServiceImpl(
    @Value("\${security.jwt.secret-key}")
    encodedKey: String,
    @Value("\${security.jwt.ttl-in-millis}")
    private val ttlInMillis: Long
) : JwtService {

    private val secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(encodedKey))
    private val jwtParser = Jwts.parser().verifyWith(secretKey).build()

    override fun extractUsername(token: String): String {
        return extractAllClaims(token).subject
    }

    override fun isTokenValidForUser(token: String, userDetails: UserDetails) =
        isTokenSigned(token) && !isTokenExpired(token) && isTokenFromUser(token, userDetails)

    override fun generateToken(userDetails: UserDetails): TokenDto {
        val expirationDate = Date(System.currentTimeMillis() + ttlInMillis)
        val token = Jwts
            .builder()
            .subject(userDetails.username)
            .issuedAt(Date())
            .expiration(expirationDate)
            .signWith(secretKey)
            .compact()

        return TokenDto(token, expirationDate)

    }

    private fun isTokenSigned(token: String) = jwtParser.isSigned(token)

    private fun isTokenExpired(token: String) = extractAllClaims(token).expiration.before(Date())

    private fun isTokenFromUser(token: String, userDetails: UserDetails) =
        extractAllClaims(token).subject.equals(userDetails.username)

    private fun extractAllClaims(token: String) = jwtParser.parseSignedClaims(token).payload
}