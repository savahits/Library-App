package ru.shmelev.libraryapp.dto.response;

import ru.shmelev.libraryapp.entity.Author;

import java.time.LocalDate;
import java.util.Objects;

public record AuthorSearchResponse(
        Long id,
        String name,
        String surname,
        LocalDate birthDate,
        String fullName
) {
    public AuthorSearchResponse {
        fullName = (name == null ? "" : name) +
                (name != null && surname != null ? " " : "") +
                (surname == null ? "" : surname);
    }

    public AuthorSearchResponse(Long id, String name, String surname, LocalDate birthDate) {
        this(id, name, surname, birthDate, null);
    }

    public static AuthorSearchResponse fromEntity(Author author) {
        Objects.requireNonNull(author, "Author cannot be null");

        return new AuthorSearchResponse(
                author.getId(),
                author.getName(),
                author.getSurname(),
                author.getBirthDate()
        );
    }
}