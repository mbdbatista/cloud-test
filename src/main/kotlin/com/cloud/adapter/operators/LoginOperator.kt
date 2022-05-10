package com.cloud.adapter.operators

import com.cloud.adapter.serializers.input.LoginInput
import com.cloud.adapter.serializers.output.LoginOutput
import com.cloud.business.dto.UserDto
import com.cloud.business.useCases.LoginUseCase
import jakarta.inject.Singleton

@Singleton
class LoginOperator(
    private val loginUseCase: LoginUseCase
) {
    fun login(input: LoginInput): LoginOutput {
        val response = loginUseCase.execute(input.toDto())
        return LoginOutput(
            user = UserDto.fromDomain(response)
        )
    }
}