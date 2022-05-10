package com.cloud.framework.repositories

import com.cloud.business.repositories.PetRepository
import com.cloud.domain.entities.Pet
import com.cloud.framework.models.PetModel
import com.cloud.framework.repositories.data.PetRepositoryData
import com.cloud.framework.utils.StringUtils
import jakarta.inject.Singleton
import java.time.LocalDateTime

@Singleton
class PetRepositoryImpl(
    private val petRepositoryData: PetRepositoryData
) : PetRepository {
    override fun getById(id: String): Pet? {
        val pet = petRepositoryData.findById(StringUtils.toObjectId(id))
        if (pet.isEmpty) {
            return null
        }
        return pet.get().toDomain()
    }

    override fun list(name: String?, type: String?, gender: String?, isAdopted: Boolean?): List<Pet> {
        var pets = petRepositoryData.findAll()
        if (!pets.any()) {
            return listOf()
        }

        if (!name.isNullOrEmpty()) {
            pets = pets.filter { it.name.contains(Regex(name)) }
        }

        if (!type.isNullOrEmpty()) {
            pets = pets.filter { it.type == type }
        }

        if (!gender.isNullOrEmpty()) {
            pets = pets.filter { it.gender == gender }
        }

        if (isAdopted != null) {
            pets = pets.filter { if (isAdopted) it.adoptedDate != null else it.adoptedDate == null }
        }

        pets = pets.sortedWith(compareBy { it.createdAt })

        return pets.map { it.toDomain() }
    }

    override fun create(pet: Pet): Pet {
        val petModel = PetModel.fromDomain(pet)
        val created = petRepositoryData.save(petModel)
        return created.toDomain()
    }

    override fun alter(pet: Pet): Pet {
        val petModel = PetModel.fromDomain(pet)
        val updated = petRepositoryData.update(petModel)
        return updated.toDomain()
    }

    override fun delete(id: String) {
        return petRepositoryData.deleteById(StringUtils.toObjectId(id))
    }

    override fun adopt(id: String, isAdopted: Boolean): Pet? {
        val entity = petRepositoryData.findById(StringUtils.toObjectId(id)).get()
        entity.adoptedDate = if (isAdopted) LocalDateTime.now() else null
        val updated = petRepositoryData.update(entity)
        return updated.toDomain()
    }

}