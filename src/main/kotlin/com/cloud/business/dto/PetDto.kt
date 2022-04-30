package com.cloud.business.dto

import com.cloud.domain.entities.Pet
import com.cloud.domain.enums.PetGender
import com.cloud.domain.enums.PetType
import java.time.LocalDateTime

data class PetDto(
    val id: String,
    val name: String,
    val type: PetType,
    val gender: PetGender,
    val adoptedDate: LocalDateTime?
) {
    fun toDomain() = Pet(
        id,
        name,
        type = type.name,
        gender = gender.name,
        adoptedDate = adoptedDate
    )

    companion object {
        fun fromDomain(pet: Pet) = PetDto(
            id = pet.id,
            name = pet.name,
            type = PetType.valueOf(pet.type),
            gender = PetGender.valueOf(pet.gender),
            adoptedDate = pet.adoptedDate
        )
    }
}