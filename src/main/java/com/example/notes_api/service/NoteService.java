package com.example.notes_api.service;

import com.example.notes_api.model.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
    private final List<Note> notes = new ArrayList<>();
    private Long nextId = 1L;

    public List<Note> getAllNotes() {
        return notes;
    }

    public Note createNote(String content) {
        Note note  = new Note(nextId++, content);
        notes.add(note);
        return note;
    }

    public void deleteNote(Long id) {
        notes.removeIf(note -> note.id().equals(id));
    }
}
