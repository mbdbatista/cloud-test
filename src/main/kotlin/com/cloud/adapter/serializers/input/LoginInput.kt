package com.cloud.adapter.serializers.input

import com.cloud.business.dto.LoginDto

data class LoginInput(
    val email: String,
    val password: String
) {
    fun toDto() = LoginDto(
        email = email,
        password = password
    )
}