package com.notes.notesapp

class NoteRepository (private val noteDao : NoteDao) {

    val allNotes = noteDao.getAllNotes()

    suspend fun insert(note : Notes){
        noteDao.insert(note)
    }

    suspend fun delete(note : Notes){
        noteDao.delete(note)
    }
}