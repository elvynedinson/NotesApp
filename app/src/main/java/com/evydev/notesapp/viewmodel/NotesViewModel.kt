package com.evydev.notesapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.evydev.notesapp.data.Note

class NotesViewModel : ViewModel() {

    private val _note = mutableStateListOf<Note>()
    val notes: List<Note> = _note

    init {
        _note.addAll(
            listOf(
                Note(1, "Primera nota", "Contenido de la primera nota"),
                Note(2, "Segunda nota", "Contenido de la segunda nota"),
                Note(3, "Tercera nota", "Contenido de la tercera nota")
            )
        )
    }

    fun addNote() {
        val newId = _note.size + 1
        _note.add(
            Note(newId, "Nota $newId", "Contenido de la nota $newId")
        )
    }

}