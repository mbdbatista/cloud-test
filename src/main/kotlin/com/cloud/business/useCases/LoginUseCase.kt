package com.cloud.business.useCases

import com.cloud.business.dto.LoginDto
import com.cloud.business.errors.ResourceNotFoundException
import com.cloud.business.repositories.UserRepository
import com.cloud.domain.entities.User
import jakarta.inject.Singleton

@Singleton
class LoginUseCase(
    private val userRepository: UserRepository
) {
    fun execute(input: LoginDto): User {
        val user = userRepository.getByEmail(input.email) ?: throw ResourceNotFoundException(code = "USR-001", message = "User without permission")
        return if (user.password == input.password) {
            user
        } else {
            throw ResourceNotFoundException(code = "USR-001", message = "User without permission")
        }
    }
}