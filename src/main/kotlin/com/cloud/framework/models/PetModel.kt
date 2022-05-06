package com.cloud.framework.models

import com.cloud.domain.entities.Pet
import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.DateCreated
import io.micronaut.data.annotation.DateUpdated
import io.micronaut.data.annotation.EmbeddedId
import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.serde.annotation.Serdeable.Serializable
import io.micronaut.serde.annotation.Serdeable.Deserializable
import org.bson.Document
import org.bson.types.ObjectId
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

@MappedEntity("pets")
@Deserializable
@Serializable
data class PetModel(
    @field:Id
    @GeneratedValue
    var id: ObjectId,
    var name: String,
    var type: String,
    var gender: String,
    var adoptedDate: LocalDateTime?,
    @field:DateCreated
    var createdAt: Instant?,
    @field:DateUpdated
    var updatedAt: Instant?
) {
    fun toDomain() = Pet(
        id = id.toHexString(),
        name,
        type,
        gender,
        adoptedDate,
        LocalDateTime.ofInstant(createdAt, ZoneOffset.ofHours(-3)),
        LocalDateTime.ofInstant(updatedAt, ZoneOffset.ofHours(-3)),
    )

    companion object {
        fun fromDomain(pet: Pet) = PetModel(
            id = ObjectId(pet.id),
            name = pet.name,
            type = pet.type,
            gender = pet.gender,
            adoptedDate = pet.adoptedDate,
            createdAt = pet.createdAt?.toInstant(ZoneOffset.ofHours(-3)),
            updatedAt = pet.updatedAt?.toInstant(ZoneOffset.ofHours(-3)),
        )
    }
}