package dev.abreu.notetaking.controllers

import dev.abreu.notetaking.model.Note
import dev.abreu.notetaking.services.NoteService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notes")
class NoteController(
    private val noteService: NoteService
) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNoSuchElementException(ex: NoSuchElementException): ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleIllegalArgumentException(ex: IllegalArgumentException): ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.BAD_REQUEST)
    }

    @GetMapping
    fun getNotes(): ResponseEntity<List<Note>> {
        return ResponseEntity.ok().body(noteService.getNotes())
    }

    @DeleteMapping("/{id}")
    fun deleteNote(@PathVariable id: String) {
        noteService.deleteNote(id)
    }

    @PostMapping
    fun createNote(@RequestBody note: Note) {
        noteService.createNote(note)
    }

}