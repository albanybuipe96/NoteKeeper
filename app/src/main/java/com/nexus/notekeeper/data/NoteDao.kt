package com.nexus.notekeeper.data

import androidx.room.*
import com.nexus.notekeeper.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Query("SELECT * FROM note WHERE id =:id")
    suspend fun getNoteByID(id: String): Note

    @Query("SELECT * FROM note")
    fun getNotes() : Flow<List<Note>>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("DELETE FROM note")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(note: Note)

}
