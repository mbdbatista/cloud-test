package com.cloud.business.dto

import com.cloud.domain.entities.User
import java.time.LocalDateTime

data class UserDto(
    val email: String,
    val password: String,
    val active: String,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
) {
    companion object {
        fun fromDomain(user: User) = UserDto(
            email = user.email,
            active = user.active,
            password = "",
            createdAt = user.createdAt,
            updatedAt = user.updatedAt
        )
    }
}