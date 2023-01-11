package com.nexus.notekeeper.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nexus.notekeeper.ui.theme.*
import java.time.Instant
import java.util.*

@Entity
data class Note(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    var color: Int,
    val date: Date = Date.from(Instant.now())
) {
        companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}
