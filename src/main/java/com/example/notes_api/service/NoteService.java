package com.example.notes_api.service;

import com.example.notes_api.dto.CreateNoteRequest;
import com.example.notes_api.dto.NoteResponse;
import com.example.notes_api.entity.Note;
import com.example.notes_api.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public List<NoteResponse> findAll() {
        return noteRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public NoteResponse create(CreateNoteRequest request) {
        Note note = Note.builder()
                .title(request.title())
                .content(request.content())
                .archived(false)
                .build();

        return toResponse(noteRepository.save(note));
    }

    public void delete(Long id) {
        noteRepository.deleteById(id);
    }

    public NoteResponse archive(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Note not found")));

        note.setArchived(true);

        return toResponse(noteRepository.save(note));
    }

    private NoteResponse toResponse(Note note) {
        return new NoteResponse(
                note.getId(),
                note.getTitle(),
                note.getContent(),
                note.isArchived()
        );
    }
}
