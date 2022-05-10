package com.cloud.framework.providers

import com.cloud.adapter.operators.LoginOperator
import com.cloud.adapter.serializers.input.LoginInput
import io.micronaut.core.async.publisher.Publishers
import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.*
import jakarta.inject.Singleton
import org.reactivestreams.Publisher

@Singleton
class BearerAuthenticationProvider(
    private val loginOperator: LoginOperator
): AuthenticationProvider {
    override fun authenticate(
        httpRequest: HttpRequest<*>?,
        authenticationRequest: AuthenticationRequest<*, *>?
    ): Publisher<AuthenticationResponse> {
        val input = LoginInput(
            email = (authenticationRequest?.identity ?: "") as String,
            password = (authenticationRequest?.secret ?: "") as String
        )
        return try {
            val response = loginOperator.login(input)
            Publishers.just(AuthenticationResponse.success(response.user.email, arrayListOf("ADMIN")))
        } catch (ex: Exception) {
            Publishers.just(AuthenticationException(AuthenticationFailed()))
        }
    }
}