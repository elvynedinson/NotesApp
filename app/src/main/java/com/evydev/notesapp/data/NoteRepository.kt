package com.evydev.notesapp.data

class NoteRepository(private val dao: NoteDao){

    val notes = dao.getNotes()

    suspend fun addNote(note: Note){
        dao.insertNote(note)
    }

    suspend fun deleteNote(note: Note){
        dao.deleteNote(note)
    }

    suspend fun updateNote(note: Note){
        dao.updateNote(note)
    }


}
