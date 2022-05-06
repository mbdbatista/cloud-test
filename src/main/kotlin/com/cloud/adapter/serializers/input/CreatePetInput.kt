package com.cloud.adapter.serializers.input

import com.cloud.business.dto.PetDto
import com.cloud.domain.enums.PetGender
import com.cloud.domain.enums.PetType
import io.micronaut.core.annotation.Introspected
import org.bson.types.ObjectId
import java.util.UUID
import javax.validation.constraints.NotBlank

@Introspected
data class CreatePetInput (
    @field:NotBlank
    val name: String,
    @field:NotBlank
    val type: PetType,
    @field:NotBlank
    val gender: PetGender
    )
{
    fun toDTO() = PetDto(
        id = ObjectId.get().toHexString(),
        name = name,
        type = type,
        gender = gender,
        adoptedDate = null,
        createdAt = null,
        updatedAt = null
    )
}