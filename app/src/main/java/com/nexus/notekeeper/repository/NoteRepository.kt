package com.nexus.notekeeper.repository

import com.nexus.notekeeper.data.NoteDao
import com.nexus.notekeeper.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {

    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }

    suspend fun getNoteByID(id: String): Note {
        return noteDao.getNoteByID(id)
    }

    fun getNotes(): Flow<List<Note>> {
        return noteDao.getNotes().flowOn(Dispatchers.IO).conflate()
    }

    suspend fun update(note: Note) {
        noteDao.update(note)
    }

    suspend fun deleteAll() {
        noteDao.deleteAll()
    }

    suspend fun deleteNote(note: Note) {
        noteDao.delete(note)
    }

}