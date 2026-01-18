package com.evydev.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.evydev.notesapp.data.NoteDatabase
import com.evydev.notesapp.data.NoteRepository
import com.evydev.notesapp.viewmodel.NotesViewModel
import com.evydev.notesapp.ui.NotesScreen
import com.evydev.notesapp.viewmodel.NotesViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val db = NoteDatabase.getInstance(this)
            val repository = NoteRepository(db.noteDao)

            val viewModel: NotesViewModel = viewModel(
                factory = NotesViewModelFactory(repository)
            )


            val notesViewModel: NotesViewModel = viewModel()
            NotesScreen(viewModel = notesViewModel)

        }
    }
}