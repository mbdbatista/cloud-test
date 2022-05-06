package com.cloud.framework.repositories.data

import com.cloud.framework.models.PetModel
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.CrudRepository
import org.bson.types.ObjectId

@MongoRepository()
interface PetRepositoryData: CrudRepository<PetModel, ObjectId>