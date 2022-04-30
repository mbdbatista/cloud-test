package com.cloud.domain.entities

import java.time.LocalDateTime

data class Pet (
    val id: String,
    val name: String,
    val type: String,
    val gender: String,
    val adoptedDate: LocalDateTime?
    )