package com.cloud.framework.repositories.data

import com.cloud.framework.models.PetModel
import io.micronaut.context.annotation.Executable
import io.micronaut.data.mongodb.annotation.MongoFindQuery
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.CrudRepository
import java.util.Optional

@MongoRepository()
interface PetRepositoryData: CrudRepository<PetModel, String> {
//    @Executable
//    fun findWithFilter(name: String?, type: String?, gender: String?): Iterable<PetModel>
}