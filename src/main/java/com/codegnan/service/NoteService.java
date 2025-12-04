package com.codegnan.service;

import java.util.List;

import com.codegnan.Entity.Note;
import com.codegnan.exception.InvalidNoteIdException;

public interface NoteService {


	    public Note createNote(Note note);

	    
	    public Note getNoteById(Long id) throws InvalidNoteIdException;

	    
	    public List<Note> getAllNotes();

	     
	    public Note updateNote(Long id, Note note) throws InvalidNoteIdException;

	   
	    public Note deleteNote(Long id) throws InvalidNoteIdException;
	}



