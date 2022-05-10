package com.cloud.domain.entities

import java.time.LocalDateTime

data class User(
    val email: String,
    val password: String,
    val active: Boolean,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
)