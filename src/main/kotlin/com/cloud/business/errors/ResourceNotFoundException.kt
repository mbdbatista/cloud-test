package com.cloud.business.errors

data class ResourceNotFoundException(
    val code: String,
    override val message: String
): RuntimeException()