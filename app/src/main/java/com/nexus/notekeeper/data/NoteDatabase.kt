package com.nexus.notekeeper.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nexus.notekeeper.data.converters.DateConverter
import com.nexus.notekeeper.data.converters.UUIDConverter
import com.nexus.notekeeper.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

}