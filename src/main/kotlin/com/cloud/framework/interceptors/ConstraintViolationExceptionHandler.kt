package com.cloud.framework.interceptors

import com.cloud.adapter.serializers.output.base.BaseOutput
import com.cloud.adapter.serializers.output.base.ErrorOutput
import com.cloud.business.errors.ResourceNotFoundException
import io.micronaut.context.annotation.Replaces
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import io.micronaut.validation.exceptions.ConstraintExceptionHandler
import jakarta.inject.Singleton
import javax.validation.ConstraintViolationException

@Produces
@Singleton
@Replaces(ConstraintExceptionHandler::class)
class ConstraintViolationExceptionHandler: ExceptionHandler<ConstraintViolationException, HttpResponse<*>> {
    override fun handle(request: HttpRequest<*>?, exception: ConstraintViolationException?): HttpResponse<*> {
        val errors = mutableListOf<ErrorOutput>()
        exception?.constraintViolations?.forEach {
            errors.add(
                ErrorOutput(
                code = it.propertyPath.last().toString(),
                message = it.message
                )
            )
        }
        val response = BaseOutput<Any>(errors = errors)
        return HttpResponse.badRequest(response)
    }
}

@Produces
@Singleton
class ResourceNotFoundExceptionHandler: ExceptionHandler<ResourceNotFoundException, HttpResponse<*>> {
    override fun handle(request: HttpRequest<*>?, exception: ResourceNotFoundException?): HttpResponse<*> {
        val errors = mutableListOf(
            ErrorOutput(exception?.code ?: "PET-000", exception?.message ?: "Unexpected error")
        )
        val response = BaseOutput<Any>(errors = errors)
        return HttpResponse.badRequest(response)
    }
}