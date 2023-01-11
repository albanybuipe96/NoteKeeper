package com.nexus.notekeeper.data

import com.nexus.notekeeper.model.Note

class NotesDataSource {

    fun getNotes(): List<Note> = listOf(
        Note(title = "Title 1", description = "Description 1"),
        Note(title = "Title 2", description = "Description 2"),
        Note(title = "Title 3", description = "Description 3"),
        Note(title = "Title 4", description = "Description 4"),
        Note(title = "Title 5", description = "Description 5"),
        Note(title = "Title 6", description = "Description 6"),
        Note(title = "Title 7", description = "Description 7"),
    )

}