package com.cloud.business.useCases

import com.cloud.business.repositories.PetRepository
import com.cloud.domain.entities.Pet
import jakarta.inject.Singleton

@Singleton
class CreatePetUseCase (
    private val petRepository: PetRepository
    ){
    fun execute(pet: Pet): Pet {
        return petRepository.create(pet)
    }
}