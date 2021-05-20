package com.notes.notesapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// entity class for table in sql
@Entity(tableName = "note_table")
data class Notes(@ColumnInfo(name = "text") val text : String) {
    @PrimaryKey(autoGenerate = true) var id : Int = 0
}