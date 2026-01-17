package com.evydev.notesapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.evydev.notesapp.data.Note
import com.evydev.notesapp.viewmodel.NotesViewModel

@Composable
fun NotesScreen(viewModel: NotesViewModel) {

    val notes = viewModel.notes

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Mis Notas")

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(notes) { note ->
                NoteItem(note)
                Spacer(modifier = Modifier.height(18.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { viewModel.addNote() }) {
            Text("Agregar Nota")
        }
    }

}

@Composable
fun NoteItem(note: Note) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(note.title)
        Text(note.content)
    }
}