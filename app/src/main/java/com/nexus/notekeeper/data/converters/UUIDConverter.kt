package com.nexus.notekeeper.data.converters

import androidx.room.TypeConverter
import java.util.*


class UUIDConverter {

    @TypeConverter
    fun fromUUID(uuid: UUID): String {
        return uuid.toString()
    }

    @TypeConverter
    fun toUUID(str: String): UUID? {
        return UUID.fromString(str)
    }

}