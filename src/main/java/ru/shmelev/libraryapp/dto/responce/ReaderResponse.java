package ru.shmelev.libraryapp.dto.responce;

public record ReaderResponse(
        Long id,
        String name,
        String surname,
        String email
) { }
