package com.evydev.notesapp.ui

import android.R.attr.clickable
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.evydev.notesapp.data.Note
import com.evydev.notesapp.viewmodel.NotesViewModel
import androidx.compose.foundation.combinedClickable

@Composable
fun NotesScreen(viewModel: NotesViewModel) {

    val notes by viewModel.notes.collectAsStateWithLifecycle()

    var noteEdit by remember { mutableStateOf<Note?>(null) }
    var titleText by remember { mutableStateOf("") }
    var contentText by remember { mutableStateOf("") }
    var noteToDelete by remember { mutableStateOf<Note?>(null) }

    if (noteToDelete != null) {
        AlertDialog(
            onDismissRequest = {
                noteToDelete = null
            },
            title = {
                Text("Eliminar Nota")
            },
            text = {
                Text("¿Seguro que deseas eliminar esta nota?")
            },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.deleteNote(noteToDelete!!)
                        noteToDelete = null
                    }
                ) {
                    Text("Eliminar")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        noteToDelete = null
                    }
                ) {
                    Text("Cancelar")
                }
            }
        )
    }


    noteEdit?.let { note ->

        var editTile by remember { mutableStateOf(note.title) }
        var editcontent by remember { mutableStateOf(note.content) }

        AlertDialog(
            onDismissRequest = {
                noteEdit = null
            },
            title = {
                Text("Editar Nota")
            },
            text = {
                Column {
                    TextField(
                        value = editTile,
                        onValueChange = { editTile = it },
                        label = { Text("Títutlo") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    TextField(
                        value = editcontent,
                        onValueChange = { editcontent = it },
                        label = { Text("Contenido") },
                        modifier = Modifier.fillMaxWidth()
                    )

                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.updateNote(
                            note.copy(
                                title = editTile,
                                content = editcontent
                            )
                        )
                        noteEdit = null
                    }
                ) {
                    Text("Guardar")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        noteEdit = null
                    }
                ) {
                    Text("Cancelar")
                }
            }
        )

    }


    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()) {
        Text("Mis Notas", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = titleText,
            onValueChange = { titleText = it },
            label = { Text("Título") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = contentText,
            onValueChange = { contentText = it },
            label = { Text("Contenido") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(18.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(notes) { note ->
                NoteItem(
                    note = note,
                    onclick = {
                        noteEdit = note
                    },
                    onLongClick = {
                        noteToDelete = note
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.addNote(titleText, contentText)
                titleText = ""
                contentText = ""
            }, modifier = Modifier.fillMaxWidth()
        ) {
            Text("Agregar Nota")
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NoteItem(note: Note, onclick: () -> Unit, onLongClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .combinedClickable(
                onClick = { onclick() },
                onLongClick = { onLongClick() }
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(note.title, style = MaterialTheme.typography.titleMedium)

            Spacer(modifier = Modifier.height(8.dp))

            Text(note.content, style = MaterialTheme.typography.bodyMedium)
        }
    }
}