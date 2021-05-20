package com.notes.notesapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
abstract class NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(note : Notes)

    @Delete
    abstract suspend fun delete(note : Notes)

    @Query("SELECT * FROM note_table ORDER BY id ASC")
    abstract fun getAllNotes() : LiveData<List<Notes>>
}