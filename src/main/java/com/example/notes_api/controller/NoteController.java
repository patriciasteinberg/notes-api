package com.example.notes_api.controller;

import com.example.notes_api.dto.CreateNoteRequest;
import com.example.notes_api.dto.NoteResponse;
import com.example.notes_api.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;


    @GetMapping
    public List<NoteResponse> findAll() {
        return noteService.findAll();
    }

    @PostMapping
    public NoteResponse create(@RequestBody CreateNoteRequest request) {
        return noteService.create(request);
    }

    @PatchMapping("/{id}/archive")
    public NoteResponse archive(@PathVariable Long id) {
        return noteService.archive(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        noteService.delete(id);
    }
}
