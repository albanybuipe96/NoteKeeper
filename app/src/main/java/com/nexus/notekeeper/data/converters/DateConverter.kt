package com.nexus.notekeeper.data.converters

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun fromDate(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun toDate(long: Long): Date {
        return Date(long)
    }

}