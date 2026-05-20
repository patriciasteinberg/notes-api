package com.example.notes_api.dto;

public record NoteResponse(
        Long id,
        String title,
        String content,
        boolean archived
) {
}
