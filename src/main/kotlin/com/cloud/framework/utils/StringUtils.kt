package com.cloud.framework.utils

import org.bson.types.ObjectId

class StringUtils {
    companion object {
        fun toObjectId(value: String) = ObjectId(value)
    }
}