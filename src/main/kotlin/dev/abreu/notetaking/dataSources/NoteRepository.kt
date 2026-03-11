package dev.abreu.notetaking.dataSources

import dev.abreu.notetaking.model.Note
import org.springframework.stereotype.Repository

@Repository
class NoteRepository {

    val mockNotes = mutableListOf<Note>(
        Note(
            title = "First Note",
            description = "This is the content of the first note."
        ),
        Note(
            title = "Second Note",
            description = "This is the content of the second note."
        )
    )

    fun getNotes() = mockNotes

    fun deleteNote(id: String) {
        val tempNote = mockNotes.firstOrNull { it.id == id }
        if (tempNote != null) {
            mockNotes.remove(tempNote)
        } else {
            throw NoSuchElementException("Note with id $id not found.")
        }
    }

    fun save(note: Note) {
        val tempNote = mockNotes.firstOrNull { it.id == note.id }
        if (tempNote == null) {
            mockNotes.add(note)
        } else {
            throw IllegalArgumentException("Note with id ${note.id} already exists.")
        }
    }

}