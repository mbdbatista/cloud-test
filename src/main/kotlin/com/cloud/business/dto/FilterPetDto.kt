package com.cloud.business.dto

import com.cloud.domain.enums.PetGender
import com.cloud.domain.enums.PetType

data class FilterPetDto(
    val name: String?,
    val type: PetType?,
    val gender: PetGender?,
    val isAdopted: Boolean?
)