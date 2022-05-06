package com.cloud.adapter.operators

import com.cloud.adapter.serializers.input.ListPetInput
import com.cloud.adapter.serializers.output.ListPetOutput
import com.cloud.business.dto.PetDto
import com.cloud.business.useCases.ListPetUseCase
import jakarta.inject.Singleton

@Singleton
class ListPetOperator (
    private val listPetUseCase: ListPetUseCase
    )
{
    fun list(input: ListPetInput): ListPetOutput {
        val pets = listPetUseCase.execute(input.toDto())
        return ListPetOutput(data = pets.map { PetDto.fromDomain(it) })
    }
}