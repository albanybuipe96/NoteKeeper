package com.nexus.notekeeper.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nexus.notekeeper.R
import com.nexus.notekeeper.components.NoteButton
import com.nexus.notekeeper.components.NoteCard
import com.nexus.notekeeper.components.NoteField
import com.nexus.notekeeper.data.NotesDataSource
import com.nexus.notekeeper.model.Note

@Composable
fun NoteScreen(notes: List<Note>, onInsert: (Note) -> Unit, onRemove: (Note) -> Unit) {
    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }

    val context: Context = LocalContext.current

    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(
            title = { Text(text = stringResource(id = R.string.app_name)) },
            actions = {
                Icon(
                    imageVector = Icons.Rounded.Notifications,
                    contentDescription = "Title icon"
                )
            }, backgroundColor = Color(0xFFDADFE3)
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoteField(
                text = title,
                label = "Title",
                onChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace() || char.isDigit()
                        }) title = it
                },
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
            )
            NoteField(
                text = description,
                label = "Description",
                onChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace() || char.isDigit()
                        }) description = it
                },
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp)
            )

            NoteButton(text = "Save", onClick = {
                if (title.isNotEmpty() && description.isNotEmpty()) {
                    // 1. Save note
                    onInsert(Note(title = title, description = description))
                    Toast.makeText(context, "Note added!", Toast.LENGTH_SHORT).show()
                    // 2. Clear fields
                    title = ""
                    description = ""
                }
            })
        }
        Divider(modifier = Modifier.padding(10.dp))
        LazyColumn {
            items(notes) { note ->
                NoteCard(note = note, onClick = {
                    onRemove(it)
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen(notes = NotesDataSource().getNotes(), onRemove = {}, onInsert = {})
}