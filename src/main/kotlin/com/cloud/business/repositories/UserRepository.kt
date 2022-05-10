package com.cloud.business.repositories

import com.cloud.domain.entities.User

interface UserRepository {
    fun getByEmail(email: String): User?
}