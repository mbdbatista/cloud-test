package com.cloud.adapter.serializers.output.base

data class BaseOutput<T>(
    val data: T? = null,
    val errors: List<ErrorOutput>? = null
)