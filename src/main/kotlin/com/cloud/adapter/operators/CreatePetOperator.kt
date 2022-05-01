package com.cloud.adapter.operators

import com.cloud.adapter.serializers.output.CreatePetOutput
import com.cloud.business.dto.PetDto
import com.cloud.business.useCases.CreatePetUseCase
import jakarta.inject.Singleton


@Singleton
class CreatePetOperator(
    private val createPetUseCase: CreatePetUseCase
) {
    fun create(petDto: PetDto): CreatePetOutput {
        val response = createPetUseCase.execute(petDto.toDomain())
        return CreatePetOutput(data = PetDto.fromDomain(response))
    }
}
