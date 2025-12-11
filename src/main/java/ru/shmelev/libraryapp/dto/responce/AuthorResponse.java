package ru.shmelev.libraryapp.dto.responce;

import java.time.LocalDate;

public record AuthorResponse(
        Long id,
        String name,
        String surname,
        LocalDate dateBirth
) {  }
