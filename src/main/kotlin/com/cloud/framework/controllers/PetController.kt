package com.cloud.framework.controllers

import com.cloud.adapter.operators.CreatePetOperator
import com.cloud.adapter.serializers.input.AlterPetInput
import com.cloud.adapter.serializers.input.CreatePetInput
import com.cloud.adapter.serializers.output.CreatePetOutput
import com.cloud.framework.ResourceNotFoundException
import io.micronaut.http.annotation.*
import javax.validation.Valid

@Controller("/pet")
open class PetController(
    private val createPetOperator: CreatePetOperator
) {

    @Get("/{id}")
    fun get(@PathVariable id: String): String {
        return "Busca o pet: $id"
    }

    @Get("/")
    fun list(@QueryValue name: String?, @QueryValue type: String?, @QueryValue gender: String?, @QueryValue isAdopted: Boolean?): String {
        return "Listando pets com name: $name, type: $type, gender: $gender, isAdopted: $isAdopted"
    }

    @Post("/")
    open fun post(@Body @Valid pet: CreatePetInput): CreatePetOutput {
        return createPetOperator.create(pet)
    }

    @Put("/{id}")
    fun put(@PathVariable id: String, @Body pet: AlterPetInput): String {
        throw ResourceNotFoundException()
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