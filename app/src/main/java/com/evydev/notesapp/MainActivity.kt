package com.evydev.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.evydev.notesapp.viewmodel.NotesViewModel
import com.evydev.notesapp.ui.NotesScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val notesViewModel: NotesViewModel = viewModel()
            NotesScreen(viewModel = notesViewModel)

        }
    }
}