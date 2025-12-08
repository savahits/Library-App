package ru.shmelev.libraryapp.dto.responce;

import java.util.Objects;

public record ReaderResponse(
        Long id,
        String name,
        String surname,
        String email
) {
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ReaderResponse(Long id1, String name1, String surname1, String email1))) return false;
        return Objects.equals(id, id1) && Objects.equals(name, name1) && Objects.equals(email, email1) && Objects.equals(surname, surname1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email);
    }
}
