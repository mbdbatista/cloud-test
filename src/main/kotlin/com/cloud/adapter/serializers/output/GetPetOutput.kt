package com.cloud.adapter.serializers.output

import com.cloud.adapter.serializers.output.base.ErrorOutput
import com.cloud.business.dto.PetDto

data class GetPetOutput (
    val data: PetDto? = null,
    val errors: List<ErrorOutput>? = null
    )