package com.cloud.adapter.serializers.input

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank

@Introspected
data class CreatePetInput (
    @field:NotBlank
    val name: String,
    @field:NotBlank
    val type: String,
    @field:NotBlank
    val gender: String
    )