package com.cloud.adapter.serializers.output.base


data class ErrorOutput(
    val code: String,
    val message: String
)