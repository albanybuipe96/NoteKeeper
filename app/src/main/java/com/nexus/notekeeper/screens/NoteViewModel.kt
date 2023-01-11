package com.nexus.notekeeper.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.nexus.notekeeper.data.NotesDataSource
import com.nexus.notekeeper.model.Note

class NoteViewModel : ViewModel() {
    private val notes = mutableStateListOf<Note>()

    init {
        notes.addAll(NotesDataSource().getNotes())
    }

    fun insert(note: Note) {
        notes.add(note)
    }

    fun remove(note: Note) {
        notes.remove(note)
    }

    fun getNotes(): List<Note> = notes
}