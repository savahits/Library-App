package ru.shmelev.libraryapp.dto.response;

import java.time.LocalDate;

public record AuthorResponse(
        Long id,
        String name,
        String surname,
        LocalDate dateBirth
) {  }
