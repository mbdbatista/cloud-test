package com.cloud.framework.models

import com.cloud.domain.entities.Pet
import io.micronaut.core.annotation.Introspected
import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonProperty
import java.time.LocalDateTime

@Introspected

data class PetModel @BsonCreator constructor(
    @param:BsonProperty("id")
    val id: String,
    @param:BsonProperty("name")
    val name: String,
    @param:BsonProperty("type")
    val type: String,
    @param:BsonProperty("gender")
    val gender: String,
    @param:BsonProperty("adoptedDate")
    val adoptedDate: LocalDateTime?
) {
    fun toDomain() = Pet(
        id, name, type, gender, adoptedDate
    )

    companion object {
        fun fromDomain(pet: Pet) = PetModel(
            id = pet.id,
            name = pet.name,
            type = pet.type,
            gender = pet.gender,
            adoptedDate = pet.adoptedDate
        )
    }
}