package com.cloud.business.repositories

import com.cloud.domain.entities.Pet

interface PetRepository {
    fun getById(id: String): Pet?
    fun list(name: String?, type: String?, gender: String?, isAdopted: Boolean?): List<Pet>
    fun create(pet: Pet): Pet
    fun alter(pet: Pet): Pet?
    fun delete(id: String): Unit
    fun adopt(id: String, isAdopted: Boolean): Pet?
}