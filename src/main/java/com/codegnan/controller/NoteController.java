package com.codegnan.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codegnan.Entity.Note;
import com.codegnan.exception.InvalidNoteIdException;
import com.codegnan.service.NoteService;


@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = "*") 
public class NoteController {

    private static final Logger logger = LoggerFactory.getLogger(NoteController.class);

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        logger.info("Creating note with title: {}", note.getTitle());
        Note created = noteService.createNote(note);
        return ResponseEntity.created(URI.create("/api/notes/" + created.getId())).body(created);
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        logger.info("Fetching all notes");
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) throws InvalidNoteIdException {
        logger.info("Fetching note by ID: {}", id);
        Note note = noteService.getNoteById(id);
        return ResponseEntity.ok(note);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note updatedNote)
            throws InvalidNoteIdException {
        logger.info("Updating note with ID: {}", id);
        Note note = noteService.updateNote(id, updatedNote);
        return ResponseEntity.ok(note);
    }

    // DELETE (void return type)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) throws InvalidNoteIdException {
        logger.info("Deleting note with ID: {}", id);
        noteService.deleteNote(id);   // returns void
        return ResponseEntity.noContent().build();  // 204 No Content
    }
}
