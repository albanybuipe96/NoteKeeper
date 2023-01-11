package com.nexus.notekeeper.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nexus.notekeeper.model.Note
import com.nexus.notekeeper.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes = _notes.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getNotes().distinctUntilChanged().collect {
                if (it.isEmpty()) {
                    Log.d("EMPTY", "Empty list")
                } else {
                    _notes.value = it
                }
            }
        }
    }

    fun insert(note: Note) = viewModelScope.launch {
//        note.color = Note.noteColors.random().toArgb()
        repository.insert(note)
    }

    fun update(note: Note) = viewModelScope.launch {
        repository.update(note)
    }

    fun remove(note: Note) = viewModelScope.launch {
        repository.deleteNote(note)
    }

}