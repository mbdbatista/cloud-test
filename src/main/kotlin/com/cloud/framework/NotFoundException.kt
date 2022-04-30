package com.cloud.framework

class ResourceNotFoundException: RuntimeException() {
    override val message: String?
        get() = "Recurso não encontrado"
}