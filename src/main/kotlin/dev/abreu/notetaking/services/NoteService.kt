package dev.abreu.notetaking.services

import dev.abreu.notetaking.dataSources.NoteRepository
import dev.abreu.notetaking.model.Note
import org.springframework.stereotype.Service

@Service
class NoteService(
    private val repository: NoteRepository
) {
    fun getNotes(): List<Note> {
        return repository.getNotes()
    }

    fun deleteNote(id: String) {
        repository.deleteNote(id)
    }

    fun createNote(note: Note) {
        repository.save(note)
    }
}