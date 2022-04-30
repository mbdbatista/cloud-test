package com.cloud.adapter.operators

import com.cloud.adapter.serializers.input.CreatePetInput
import com.cloud.adapter.serializers.output.CreatePetOutput
import com.cloud.adapter.serializers.output.ErrorOutput
import com.cloud.business.dto.PetDto
import com.cloud.business.useCases.CreatePetUseCase
import com.cloud.domain.enums.PetGender
import com.cloud.domain.enums.PetType
import jakarta.inject.Singleton


@Singleton
class CreatePetOperator(
    val createPetUseCase: CreatePetUseCase
) {
    fun create(createPetInput: CreatePetInput): CreatePetOutput {
        val errors = validate(createPetInput)
        if (errors.isNotEmpty()) {
            return CreatePetOutput(errors = errors)
        }
        println("createPetOperator::$createPetInput")
        return CreatePetOutput(data = PetDto(id = "1", name = "Bartholomeu", type = PetType.DOG, gender = PetGender.FEMALE, adoptedDate = null))
    }

    private fun validate(createPetInput: CreatePetInput): List<ErrorOutput> {
        val errors = mutableListOf<ErrorOutput>()
        if (createPetInput.name.isBlank()){
            errors.add(ErrorOutput(code = "name", message = "name is mandatory"))
        }

        if (createPetInput.type.isBlank()){
            errors.add(ErrorOutput(code = "type", message = "type is mandatory"))
        }

        if (createPetInput.gender.isBlank()){
            errors.add(ErrorOutput(code = "gender", message = "gender is mandatory"))
        }

        return errors
    }
}
