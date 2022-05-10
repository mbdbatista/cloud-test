package com.cloud.framework.models

import com.cloud.domain.entities.User
import io.micronaut.data.annotation.*
import io.micronaut.serde.annotation.Serdeable.Serializable
import io.micronaut.serde.annotation.Serdeable.Deserializable
import org.bson.types.ObjectId
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

@MappedEntity("users")
@Deserializable
@Serializable
data class UserModel(
    @field:Id
    @GeneratedValue
    var id: ObjectId,
    var email: String,
    var password: String,
    var active: Boolean,
    @field:DateCreated
    var createdAt: Instant?,
    @field:DateUpdated
    var updatedAt: Instant?
) {
    fun toDomain() = User(
        email = email,
        password = password,
        active = active,
        createdAt = LocalDateTime.ofInstant(createdAt, ZoneOffset.ofHours(-3)),
        updatedAt = LocalDateTime.ofInstant(updatedAt, ZoneOffset.ofHours(-3))
    )
}