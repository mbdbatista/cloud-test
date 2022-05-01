package com.cloud.business.dto

import com.cloud.domain.entities.Pet
import com.cloud.domain.enums.PetGender
import com.cloud.domain.enums.PetType
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class PetDto(
    val id: String,
    val name: String,
    val type: PetType,
    val gender: PetGender,
    @get:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    val adoptedDate: LocalDateTime?,
    @get:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    val createdAt: LocalDateTime?,
    @get:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    val updatedAt: LocalDateTime?
) {
    fun toDomain() = Pet(
        id,
        name,
        type = type.name,
        gender = gender.name,
        adoptedDate = adoptedDate,
        createdAt = createdAt,
        updatedAt = updatedAt
    )

    companion object {
        fun fromDomain(pet: Pet) = PetDto(
            id = pet.id,
            name = pet.name,
            type = PetType.valueOf(pet.type),
            gender = PetGender.valueOf(pet.gender),
            adoptedDate = pet.adoptedDate,
            createdAt = pet.createdAt,
            updatedAt = pet.updatedAt
        )
    }
}