package com.cloud.framework.repositories

import com.cloud.business.repositories.UserRepository
import com.cloud.domain.entities.User
import com.cloud.framework.repositories.data.DataUserRepository
import jakarta.inject.Singleton

@Singleton
class UserRepositoryImpl(
    private val dataUserRepository: DataUserRepository
): UserRepository {
    override fun getByEmail(email: String): User? {
        val user = dataUserRepository.getByEmail(email)
        return if (user.isPresent) {
            user.get().toDomain()
        } else {
            null
        }
    }
}