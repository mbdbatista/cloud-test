package com.cloud.business.useCases

import com.cloud.business.errors.ResourceNotFoundException
import com.cloud.business.repositories.PetRepository
import com.cloud.domain.entities.Pet
import jakarta.inject.Singleton

@Singleton
class GetPetUseCase (
    private val petRepository: PetRepository
        )
{
    fun execute(id: String): Pet {
        return petRepository.getById(id) ?: throw ResourceNotFoundException(code = "PET-001", message = "Pet not found.")
    }
}