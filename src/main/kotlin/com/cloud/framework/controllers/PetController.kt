package com.cloud.framework.controllers

import com.cloud.adapter.operators.CreatePetOperator
import com.cloud.adapter.operators.GetPetOperator
import com.cloud.adapter.operators.ListPetOperator
import com.cloud.adapter.serializers.input.AlterPetInput
import com.cloud.adapter.serializers.input.CreatePetInput
import com.cloud.adapter.serializers.input.ListPetInput
import com.cloud.adapter.serializers.output.CreatePetOutput
import com.cloud.adapter.serializers.output.GetPetOutput
import com.cloud.adapter.serializers.output.ListPetOutput
import com.cloud.domain.enums.PetGender
import com.cloud.domain.enums.PetType
import io.micronaut.http.annotation.*
import javax.validation.Valid

@Controller("/pet")
open class PetController(
    private val createPetOperator: CreatePetOperator,
    private val getPetOperator: GetPetOperator,
    private val listPetOperator: ListPetOperator
) {

    @Get("/{id}")
    fun get(@PathVariable id: String): GetPetOutput {
        return getPetOperator.get(id)
    }

    @Get("/")
    fun list(@QueryValue name: String?, @QueryValue type: PetType?, @QueryValue gender: PetGender?, @QueryValue isAdopted: Boolean?): ListPetOutput {
        val input = ListPetInput(
            name = name,
            type = type,
            gender = gender,
            isAdopted = isAdopted
        )
        return listPetOperator.list(input)
    }

    @Post("/")
    open fun post(@Body @Valid pet: CreatePetInput): CreatePetOutput {
        return createPetOperator.create(pet.toDTO())
    }

    @Put("/{id}")
    fun put(@PathVariable id: String, @Body pet: AlterPetInput): String {
        return "Atualizando o pet, id: $id, name: ${pet.name}, type: ${pet.type}, gender: ${pet.gender}"
    }

    @Delete("/{id}")
    fun delete(@PathVariable id: String): String {
        return "Deletando o pet id: $id"
    }

    @Patch("/{id}")
    fun patch(@PathVariable id: String, @Body("isAdopted") isAdopted: Boolean?): String {
        return "Adotando o pet id: $id, isAdopted: $isAdopted"
    }
}