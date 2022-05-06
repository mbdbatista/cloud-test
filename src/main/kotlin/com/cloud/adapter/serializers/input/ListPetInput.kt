package com.cloud.adapter.serializers.input

import com.cloud.business.dto.FilterPetDto
import com.cloud.domain.enums.PetGender
import com.cloud.domain.enums.PetType

data class ListPetInput (
    val name: String?,
    val type: PetType?,
    val gender: PetGender?,
    val isAdopted: Boolean?
    )
{
    fun toDto() = FilterPetDto(
        name = name,
        type = type,
        gender = gender,
        isAdopted = isAdopted
    )
}