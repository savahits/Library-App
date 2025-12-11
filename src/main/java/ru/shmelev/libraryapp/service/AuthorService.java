package ru.shmelev.libraryapp.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shmelev.libraryapp.dto.responce.AuthorResponse;
import ru.shmelev.libraryapp.entity.Author;
import ru.shmelev.libraryapp.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional()
    public List<AuthorResponse> findAll() {
        return authorRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    private AuthorResponse toResponse(Author author) {
        return new AuthorResponse(
                author.getId(),
                author.getName(),
                author.getSurname(),
                author.getBirthDate()
        );
    }


}
