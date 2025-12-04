package com.codegnan.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.codegnan.Entity.Note;
import com.codegnan.exception.InvalidNoteIdException;
import com.codegnan.repository.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService {
	

	    private static final Logger logger = LoggerFactory.getLogger(NoteServiceImpl.class);

	    private final NoteRepository noteRepository;

	    public NoteServiceImpl(NoteRepository noteRepository) {
	        this.noteRepository = noteRepository;
	    }

	    @Override
	    public Note createNote(Note note) {
	        logger.info("Creating new note: {}", note.getTitle());
	        return noteRepository.save(note);
	    }

	    @Override
	    public Note getNoteById(Long id) throws InvalidNoteIdException {
	        logger.info("Fetching note with ID: {}", id);

	        return noteRepository.findById(id)
	                .orElseThrow(() -> new InvalidNoteIdException("Note not found with ID: " + id));
	    }

	    @Override
	    public List<Note> getAllNotes() {
	        logger.info("Fetching all notes");
	        return noteRepository.findAll();
	    }

	    @Override
	    public Note updateNote(Long id, Note note) throws InvalidNoteIdException {
	        logger.info("Updating note with ID: {}", id);

	        Note existingNote = noteRepository.findById(id)
	                .orElseThrow(() -> new InvalidNoteIdException("Note not found with ID: " + id));

	        existingNote.setTitle(note.getTitle());
	        existingNote.setContent(note.getContent());

	        return noteRepository.save(existingNote);
	    }

	    @Override
	    public Note deleteNote(Long id) throws InvalidNoteIdException {
	    	logger.info("Deleting note with ID: {}", id);

	        Note existingNote = noteRepository.findById(id)
	                .orElseThrow(() -> new InvalidNoteIdException("Note not found with ID: " + id));

	        noteRepository.delete(existingNote);

	        return existingNote; // return deleted object
	    }
	}
