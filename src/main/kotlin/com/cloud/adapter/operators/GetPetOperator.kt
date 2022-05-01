package com.cloud.adapter.operators

import com.cloud.adapter.serializers.output.GetPetOutput
import com.cloud.business.dto.PetDto
import com.cloud.business.useCases.GetPetUseCase
import jakarta.inject.Singleton

@Singleton
class GetPetOperator (
    private val getPetUseCase: GetPetUseCase
    )
{
    fun get(id: String): GetPetOutput {
        val pet = getPetUseCase.execute(id)
        return GetPetOutput(data = PetDto.fromDomain(pet))
    }
}