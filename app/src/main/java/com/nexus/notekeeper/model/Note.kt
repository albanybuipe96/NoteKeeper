package com.nexus.notekeeper.model

import java.time.LocalDateTime
import java.util.*

data class Note(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val date: LocalDateTime = LocalDateTime.now()
)
