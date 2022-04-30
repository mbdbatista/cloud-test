package com.cloud.adapter.serializers.output

data class BaseOutput<T>(
    val data: T? = null,
    val errors: List<ErrorOutput>? = null
)