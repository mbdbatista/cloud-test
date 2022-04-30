package com.cloud.business.repositories

import com.cloud.domain.entities.Pet
import com.cloud.domain.enums.PetGender
import com.cloud.domain.enums.PetType

interface PetRepository {
    fun getById(id: String): Pet
    fun list(name: String?, type: PetType?, gender: PetGender?, isAdopted: Boolean?): List<Pet>
    fun create(pet: Pet): Pet
    fun alter(id: String, pet: Pet): Pet
    fun delete(id: String): Pet
    fun adopt(id: String, isAdopted: Boolean): Pet
}