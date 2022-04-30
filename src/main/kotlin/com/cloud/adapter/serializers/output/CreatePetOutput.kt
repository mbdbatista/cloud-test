package com.cloud.adapter.serializers.output

import com.cloud.business.dto.PetDto

data class CreatePetOutput(
    val data: PetDto? = null,
    val errors: List<ErrorOutput>? = null
)