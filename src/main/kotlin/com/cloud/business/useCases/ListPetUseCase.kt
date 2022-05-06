package com.cloud.business.useCases

import com.cloud.business.dto.FilterPetDto
import com.cloud.business.errors.ResourceNotFoundException
import com.cloud.business.repositories.PetRepository
import com.cloud.domain.entities.Pet
import jakarta.inject.Singleton

@Singleton
class ListPetUseCase (
    private val petRepository: PetRepository
    )
{
    fun execute(filter: FilterPetDto): List<Pet> {
        return petRepository.list(filter.name, filter.type.toString(), filter.gender.toString(), filter.isAdopted)
    }
}