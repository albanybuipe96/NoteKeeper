package com.nexus.notekeeper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nexus.notekeeper.screens.NoteScreen
import com.nexus.notekeeper.screens.NoteViewModel
import com.nexus.notekeeper.ui.theme.NoteKeeperTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteKeeperTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val viewModel: NoteViewModel = viewModel()
                    val notes = viewModel.getNotes()
                    NoteScreen(notes = notes, onInsert = {
                        viewModel.insert(it)
                    }, onRemove = {
                        viewModel.remove(it)
                    })
                }
            }
        }
    }
}

